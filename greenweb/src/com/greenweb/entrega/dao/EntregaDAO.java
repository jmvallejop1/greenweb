package com.greenweb.entrega.dao;
import com.greenweb.entrega.data.*;
import com.greenweb.noticia.data.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.greenweb.ConnectionManager;
import com.greenweb.cartel.dao.*;
import com.greenweb.cartel.data.*;
import com.greenweb.pregunta.dao.*;
import com.greenweb.pregunta.data.*;
import com.greenweb.usuario.dao.*;
import com.greenweb.usuario.data.*;

public class EntregaDAO {
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    static final int MAXCARTELES=20;
    
    public boolean subirEntrega(String idUser, CartelDO c) {
    	try {
    		if(!puedeEntregar(idUser)) return false;
    		if(haEntregado(idUser)) {
    			PreguntaDO p=c.getPreg();
    			NoticiaDO n=c.getNoti();
    			String updatep="update preguntas set preguntas='"+p.getPreg()+
    					"', resp1='"+p.getR1()+"', resp2='"+p.getR2()+
    					"', resp3='"+p.getR3()+"', resp4='"+p.getR4()+"', respcorrecta="+p.getrOk()+
    					" where id="+p.getId();
    			connect=ConnectionManager.getConnection();
                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                // Miramos cuantos carteles tiene
                System.out.println("Ejecutando update pregunta: "+updatep);
                int modifp=statement.executeUpdate(updatep);
                if(modifp==1) System.out.println("Se ha modificado una pregunta");
                
                //Ya habremos actualizado la pregunta
                String video=n.getVideo();
                if(video==null)video="null";
                else video='\''+video+'\'';
                String updaten="update noticias set titulo='"+n.getTitulo()+
    					"', texto='"+n.getTexto()+"', video="+video+" where id="+n.getId();
                connect=ConnectionManager.getConnection();
                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                // Miramos cuantos carteles tiene
                System.out.println("Ejecutando update noticia: "+updaten);
                int modifn=statement.executeUpdate(updaten);
                if(modifn==1) System.out.print("Se ha modificado una noticia");
                
                String update="update carteles set ";
                String[] autores=c.getCreadores();
                for(int i=0; i<5; i++) {
                	update+="creador"+(i+1)+'=';
                	if(autores[i]==null) {
                		update+="NULL";
                	}
                	else {
                    	update+='\''+autores[i]+'\'';
                	}
                	if(i<4)update+=", ";
                }
                update+=" where id="+c.getId();
                int modifc=statement.executeUpdate(update);
                if(modifc==1) System.out.println("Se ha modificado un cartel");
                return true;
    		}
    		else {
    			CartelDAO cdao=new CartelDAO();
    			if(cdao.subirCartel(c)) { //Si hemos logrado subir el cartel lo añadiremos a la tabla entregados
    				connect=ConnectionManager.getConnection();
    	            // Statements allow to issue SQL queries to the database
    	            statement = connect.createStatement();
    	            // Result set get the result of the SQL query
    	            //Primero obtenemos el numero de la entrega actual del usuario
    	            resultSet = statement.executeQuery("select max(nument) from turnoEnt where iduser='"+idUser+"'");
    	            if(!resultSet.next())return false;
    	            if(resultSet.getString("max(nument)")==null) {
    	            	System.out.println("El usuario "+ idUser+" no tiene turno de entrega");
    	            	return false;
    	            }
    	            int entActual=Integer.parseInt(resultSet.getString("max(nument)"));
    	            String insert="insert into entregados values("+entActual+", "+c.getId()+", 0)";
    	            int res= statement.executeUpdate(insert);
    	            return res==1;
    			}
    			return false;
    		}
    	}
    	catch(Exception e){
            e.printStackTrace();
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    public boolean iniciarReto(int cartelGanador) { //EJECUTAR SIEMPRE ASEGURANDO QUE HAY UNA NUEVA ENTREGA DISTINTA DE LA ACTUAL
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            //Primero actualizo la entregavigente
        	String entVig="select max(num) from entregavigente";
            resultSet = statement.executeQuery(entVig);
            int nextEntrega=0;
            if(resultSet.next()) nextEntrega=Integer.parseInt(resultSet.getString("max(num)"))+1;
            else return false;
            resultSet=statement.executeQuery("select num from entregas where num="+nextEntrega);
            if(resultSet.next()) {
            	int res=statement.executeUpdate("update entregavigente set num="+nextEntrega);
            	if(res!=1) return false;
            }
            else {
            	System.out.println("Se debe añadir una entrega antes");
            	return false;
            }
            // Ahora añadimos el cartel ganador a la tabla de retos actuales
            resultSet = statement.executeQuery("select max(id) from retos");
            int idReto=0;
            if(resultSet.next()) idReto=Integer.parseInt(resultSet.getString("max(id)"))+1;
            else return false;
            String insert="insert into retos values("+idReto+", "+cartelGanador+", 0, 0, 0, 0, 0)";
            System.out.println(insert);
            int res = statement.executeUpdate(insert);
        	boolean okay=true;
            if(res==1) {
            	//Una vez se ha definido el cartel ganador como reto actual debemos actualizar los puntos de los usuarios que hayan contestado
            	int idRetoViejo=idReto-1; //Con esto buscaremos en la tabla de respuestasu
            	UsuarioDAO udao=new UsuarioDAO();
            	PreguntaDAO pdao=new PreguntaDAO();
            	String consulta="select iduser, respra, idp1, respp1, idp2, respp2, idp3, respp3, idp4, respp4 from respuestasu where idreto="+idRetoViejo;
            	resultSet=statement.executeQuery(consulta);
            	while(resultSet.next() && okay) {
            		UsuarioDO u=udao.obtenerUsuario(resultSet.getString("iduser"));
            		int puntosUser=u.getPuntos();
            		int respra=pdao.resPreguntaRetoActual();
            		if(respra==Integer.parseInt(resultSet.getString("respra")))puntosUser+=10;
            		else puntosUser-=5;
            		int numfallos=0;
            		int numrespuestas=0;
            		if(resultSet.getString("respp1")!=null) {
            			numrespuestas++;
            			int respad=Integer.parseInt(resultSet.getString("respp1"));
            			if(respad!=pdao.resPregunta(Integer.parseInt(resultSet.getString("idp1")))) numfallos++;
            		}
            		if(resultSet.getString("respp2")!=null) {
            			numrespuestas++;
            			int respad=Integer.parseInt(resultSet.getString("respp2"));
            			if(respad!=pdao.resPregunta(Integer.parseInt(resultSet.getString("idp2")))) numfallos++;
            		}
            		if(resultSet.getString("respp3")!=null) {
            			numrespuestas++;
            			int respad=Integer.parseInt(resultSet.getString("respp3"));
            			if(respad!=pdao.resPregunta(Integer.parseInt(resultSet.getString("idp3")))) numfallos++;
            		}
            		if(resultSet.getString("respp4")!=null) {
            			numrespuestas++;
            			int respad=Integer.parseInt(resultSet.getString("respp4"));
            			if(respad!=pdao.resPregunta(Integer.parseInt(resultSet.getString("idp4")))) numfallos++;
            		}
            		if(numrespuestas>0) { //No ha respondido a ninguna pregunta adicional
            			if(numrespuestas==1) {
            				if (numfallos==0) puntosUser+=1;
            				else puntosUser-=1;
            			}
            			else if (numrespuestas==2) {
            				switch(numfallos) {
                    		case 0: puntosUser+=2;
                    		case 1: puntosUser+=1;
                    		case 2: puntosUser-=2;
                    		}
            			}
            			else if(numrespuestas==3) {
            				switch(numfallos) {
            				case 0: puntosUser+=3;
            				case 1: puntosUser+=1;
            				default: puntosUser-=3;
            				}
            			}
            			else {
            				switch(numfallos) {
            				case 0: puntosUser+=5;
            				case 1: puntosUser+=3;
            				case 2: puntosUser-=1;
            				default: puntosUser-=3;
            				}
            			}
            		}
            		if(puntosUser<0)puntosUser=0;
            		//Ya hemos calculado el nuevo valor de los puntos del usuario
            		String update="update usuarios set puntos="+puntosUser+" where username='"+u.getUsername()+'\'';
                	System.out.println("Ejecutando: "+update);
            		res=statement.executeUpdate(update);
            		if(res!=1) {
            			okay=false;
            			System.out.println("ERROR - NO SE HA PODIDO ACTUALIZAR LOS PUNTOS DE "+u.getUsername());
            		}
            	}
            	System.out.println("Todos los usuarios actualizados "+okay);
            	return okay;
            }
            else return false;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
    	finally {
    		close();
    	}
		return false;
    }
    

	//Devuelve la fecha limite en la que se debe realizar la entrega
    public String fechaEntrega(String iduser) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select fecha from entregas where num=(select max(nument) from turnoent where iduser='"+iduser+"')");
            if(resultSet.next()) return resultSet.getString("fecha");
            else return null;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
    	 finally {
	            close();
	     }
		return null;
    }
    
    public boolean puedeEntregar(String iduser) {
    	try {
    		if(haEntregado(iduser))return false;
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select max(a.num), max(b.nument) from entregavigente a, turnoent b where b.iduser='"+iduser+"'");
            if(resultSet.next()) {
            	int nument=Integer.parseInt(resultSet.getString("max(a.num)"));
            	int entuser=Integer.parseInt(resultSet.getString("max(b.nument)"));
            	return nument==entuser;
            }
            else return false;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    public int numEntrega(String fecha) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select num from entregas where fecha='"+fecha+'\'');
            if(resultSet.next()) {
            	return Integer.parseInt(resultSet.getString("num"));
            }
            else return -1;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
		return -1;
    }
    
    public boolean nuevaEntrega(String fecha) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select max(num) from entregas");
            if(resultSet.next()) {
            	int nument=Integer.parseInt(resultSet.getString("max(num)"))+1;
            	int res=statement.executeUpdate("insert into entregas values("+nument+", '"+fecha+"')");
            	return res==1;
            }
            else return false;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    //Se puede invocar con el numero de entrega deseado o con -1 para asignarle al usuario la ultima entrega
    public boolean setNumEntrega(String username) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	resultSet = statement.executeQuery("select max(num) from entregas");
        	int numEntrega=-1;
            if(resultSet.next()) numEntrega=Integer.parseInt(resultSet.getString("max(num)"));
            else return false;
            resultSet = statement.executeQuery("select * from turnoent where iduser='"+username+'\'');
            if(!resultSet.next()) {
            	int res = statement.executeUpdate("insert into turnoent values('"+username+"', "+numEntrega+')');
                return res==1;
            }
            else {
            	int res = statement.executeUpdate("update turnoent set nument="+numEntrega+" where iduser='"+username+"'");
                return res==1;
            }
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    public boolean tieneEntrega(String iduser) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            if(resultSet.next()) {
            	return true;
            }
            else return false;
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    public String fechaModificacion(String iduser) { 
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select idcar from entregados where ident=(select max(nument) from turnoent where iduser='"+iduser+"')");
            int[] carteles=new int[MAXCARTELES]; int i=0;
            while(resultSet.next())  {
            	carteles[i]=Integer.parseInt(resultSet.getString("idcar"));
            	i++;
            }
            if(i==0) return null;
            String select="Select fechasubida from carteles where (id="+carteles[0];
            //Habremos obtenido una lista con todos los carteles entregados en la entrega del usuario
    		for(int j=1; j<i; j++) {
            	select+=" or id="+carteles[j];
            }
            select+=") and (creador1='"+iduser+"' or creador2='"+iduser+"' or creador3='"+iduser+"' or creador4='"+iduser+"' or creador5='"+iduser+"')";
            //System.out.println("Consulta: "+select);
            resultSet = statement.executeQuery(select);
            if(resultSet.next()) return resultSet.getString("fechasubida");
            else return null;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
    	 finally {
	            close();
	     }
		return null;
    }
    
    public boolean haEntregado(String username) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Miramos cuantos carteles tiene
            String cartelesUser="select id from carteles where creador1='"+username+"' or creador2='"+username+"' or creador3='"+username+"' or creador4='"+username+"' or creador5='"+username+"'";
            resultSet = statement.executeQuery(cartelesUser);
            if(!resultSet.next())return false;
            //El usuario username ha colaborado en al menos un cartel
            int[] carteles=new int[MAXCARTELES];
            carteles[0]=Integer.parseInt(resultSet.getString("id"));
            int i=1;
            while(resultSet.next()) {
            	carteles[i]=Integer.parseInt(resultSet.getString("id"));
            	i++;
            }
            resultSet = statement.executeQuery("select max(nument) from turnoEnt where iduser='"+username+"' and");
            if(!resultSet.next())return false;
            int turnoActual=Integer.parseInt(resultSet.getString("max(nument)"));
            //Cogemos el turno de entrega actual del usuario
            String consulta="select * from entregados where ident="+turnoActual+" and (idcar="+carteles[0];
            for(int j=1; j<i; j++) {
            	consulta+=" or idcar="+carteles[j];
            }
            consulta+=")";
            System.out.println("Ejecutando: "+consulta);
            resultSet = statement.executeQuery(consulta);
            if(resultSet.next()) return true;
            else return false;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
    	finally {
    		close();
    	}
		return false;
    }
    
    
    public EntregaDO crearEnt(int idcartel, int identrega) {
    	EntregaDO nueva=new EntregaDO();
    	try {
        	nueva.setIdCartel(idcartel);
        	nueva.setIdEntrega(identrega);
        	nueva.setVotos(0);
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	return nueva;
    }
    
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
