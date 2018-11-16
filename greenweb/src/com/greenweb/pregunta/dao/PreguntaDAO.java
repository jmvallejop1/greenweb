package com.greenweb.pregunta.dao;
import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.greenweb.ConnectionManager;
import com.greenweb.pregunta.data.PreguntaDO;

public class PreguntaDAO {
	private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public List<PreguntaDO> obtenerPreguntas() throws Exception {
    	 List<PreguntaDO> resultado=new LinkedList<PreguntaDO>();
    	 try {
	        	connect=ConnectionManager.getConnection();
	            // Statements allow to issue SQL queries to the database
	            statement = connect.createStatement();
	            // Result set get the result of the SQL query
	            resultSet = statement.executeQuery("select id, preguntas, resp1, resp2, resp3, resp4, respcorrecta from preguntas");
	           
	            while (resultSet.next()) {
	            	PreguntaDO p=new PreguntaDO();
	            	p.setId(Integer.parseInt(resultSet.getString("id")));
	            	p.setPreg(resultSet.getString("preguntas"));
	            	p.setR1(resultSet.getString("resp1"));
	            	p.setR2(resultSet.getString("resp2"));
	            	p.setR3(resultSet.getString("resp3"));
	            	p.setR4(resultSet.getString("resp4"));
	            	p.setrOk(Integer.parseInt(resultSet.getString("respcorrecta")));
	            	resultado.add(p);
	            }
	            

	        }
    	 catch (Exception e) {
             e.printStackTrace();
	            throw e;
	     }
    	 finally {
	            close();
	     }
	     return resultado;
    }
    
    public boolean obtenerPregunta(int id, PreguntaDO p) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from preguntas where id="+id);
            if(resultSet.next()) {
            	p.setId(Integer.parseInt(resultSet.getString("id")));
            	p.setPreg(resultSet.getString("preguntas"));
            	p.setR1(resultSet.getString("resp1"));
            	p.setR2(resultSet.getString("resp2"));
            	p.setR3(resultSet.getString("resp3"));
            	p.setR4(resultSet.getString("resp4"));
            	p.setrOk(Integer.parseInt(resultSet.getString("respcorrecta")));
            	return true;
            }
            else return false;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		System.out.println("No se pudo obtener la pregunta: "+p.getId());
    	}
		return false;
    }
    
    public List<PreguntaDO> obtener5(List<PreguntaDO> todos,int ini){
    	List<PreguntaDO> resultado=new LinkedList<PreguntaDO>();
    	for(int i = ini;i<ini + 5;i++) {
    		PreguntaDO preg =new PreguntaDO();
    		preg = todos.get(i);
    		resultado.add(preg);
    	}
    	return resultado;
    }
    
//----------------------------------------RESPONDER PREGUNTAS-------------------------------
    
    //El usuario responde por primera vez al reto actual
    public boolean responderPregRetoActual(String idU, int res) { //Devolverá un booleano para caso de error
    	//Habrá que crear una nueva entrada en respuestasU
    	//Alli almacenaremos la respuesta dada
    	//También debemos asociar 4 preguntas de otros años aleatoriamente
    	boolean todoOK=false;
    	try {
        	int idRA=idRetoActual();
            int idPRA=idPreguntaRetoActual();
            int[] enteros= PregRand(idPRA);
            connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            System.out.println("Comprobando si el usuario ya ha respondido a la pregunta");
            String stat="select * from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos)";
        	resultSet=statement.executeQuery(stat);
            System.out.println("Ejecutada la sentencia: "+stat);
        	if(resultSet.next()) todoOK=false; //El usuario ya ha respondido al reto 
        	else{
        		String insert="insert into respuestasu values('"+idU+"', "+enteros[0]+", "+enteros[1]+", "+enteros[2]+", "+enteros[3]+", "+idRA+", "+res+", NULL, NULL, NULL, NULL)";
                System.out.println("Ejecutando la sentencia: "+insert);
        		int resu=statement.executeUpdate(insert);//NO SE EJECUTA CORRECTAMENTE
        		System.out.println("Lineas modificadas: "+resu); //ESTO YA NO LO MUESTRA
                todoOK=resu==1;
        	}
            return todoOK;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    		todoOK=false;
    	}
    	finally {
            close();
    	}
    	return todoOK;
    }
    
    //Responder a una pregunta del reto adicional
    public boolean responderPregRetoAdicional(String idU, int res, int idPreg) { //Devolverá un booleano para caso de ya haber respondido
    	//Habrá que modificar la entrada correspondiente en respuestasU
    	//Alli almacenaremos la respuesta dada
    	boolean todoOK=false;
    	try {
            //Ahora obtenemos las preguntas 
        	int[] pregs=getPregsAdi(idU);
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            System.out.println("Comprobando si el usuario ya ha respondido a la pregunta");
        	String update="update respuestasu set ";
        	String stat = null;
        	if (idPreg==pregs[0]) {
        		update+="respp1="+res;
            	stat="select respp1 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos) and respp1 is not null";
        	}
        	else if(idPreg==pregs[1]) {
        		update+="respp2="+res;
            	stat="select respp2 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos) and respp2 is not null";
        	}
        	else if(idPreg==pregs[1]) {
        		update+="respp3="+res;
            	stat="select respp3 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos) and respp3 is not null";
        	}
        	else if(idPreg==pregs[1]) {
        		update+="respp4="+res;
            	stat="select respp4 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos) and respp4 is not null";
        	}
        	resultSet=statement.executeQuery(stat);
        	if(resultSet.next()) todoOK=false;
        	else {
        		update+=" where iduser='"+idU+"' and idreto=(select max(id) from retos)";
                System.out.println("Ejecutando la sentencia: "+update);
            	int resu=statement.executeUpdate(update);//NO SE EJECUTA CORRECTAMENTE
                System.out.println("Lineas modificadas: "+resu); //ESTO YA NO LO MUESTRA
                todoOK=resu==1;
        	}
            return todoOK;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    		todoOK=false;
    	}
    	finally {
            close();
    	}
    	return todoOK;
    }
    
  //FUNCIONA
    public boolean responderPreg(String idU, int res, int idPreg) { //Devolverá un booleano indicando si debe mostrar la respuesta o no
    	boolean todoOK=false;
    	try {
    		if(mostrarRes(idU, idPreg)) {
    			connect=ConnectionManager.getConnection();
                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
    			todoOK=true;
    			String correcta="select respcorrecta from preguntas where id=(select idpreg from carteles where id=(select idcartel from retos where id=(select max(id) from retos)))";
				System.out.println("Se va a ejecutar: "+correcta);
				resultSet=statement.executeQuery(correcta);
    			if(resultSet.next()) {
    				//System.out.println("Se va a comprobar si la respuesta es correcta");
    	        	int respOk=Integer.parseInt(resultSet.getString("respcorrecta"));
    	        	if(esRespOk(respOk, res)) todoOK=true;
    			}
    		}
    		else todoOK=false;
        }
    	catch (Exception e) {
            e.printStackTrace();
    		todoOK=false;
    	}
    	finally {
            close();
    	}
    	return todoOK;
    }

//----------------------------------------BORRAR Y AÑADIR PREGUNTAS-------------------
    public boolean anadirPregunta(PreguntaDO p) {
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            if(!existePregunta(p.getPreg(),p.getrOk())) {
            	String insert="insert into preguntas values("+p.getId()+", '"+p.getPreg()+"', '"+p.getR1()+"', '"+p.getR2()+"', '"+p.getR3()+"', '"+p.getR4()+"', "+p.getrOk()+')';
               	//System.out.println(insert);
                int res=statement.executeUpdate(insert);
               	//System.out.println("Se han modificado: "+res+" lineas");
                return res==1;
            }
            else {
            	//System.out.println("La pregunta ya existe");
            	return false;
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
    /*
    public boolean borrarPregunta(PreguntaDO p) {
    	boolean resul=false;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String delete="delete from preguntas where id="+p.getId();
            int res=statement.executeUpdate(delete);
            resul=res==1;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	finally {
            close();
    	}
    	return resul;
    }
    public boolean borrarPregunta(int idPreg) {
    	boolean resul=false;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String delete="delete from preguntas where id="+idPreg;
            int res=statement.executeUpdate(delete);
            System.out.println("Se ha borrado la pregunta usando: "+delete);
            resul=res==1;
    	}
    	catch (Exception e) {
            e.printStackTrace();
            resul= false;
    	}
    	finally {
            close();
    	}
    	return resul;
    }
    */
//-----------------------------------LISTAR Y MOSTRAR PREGUNTAS---------------------------------
    public void listarTodas() throws Exception {
    	PreguntaDAO dao= new PreguntaDAO();
    	List<PreguntaDO> lista=dao.obtenerPreguntas();
    	Iterator<PreguntaDO> i = lista.iterator();
		System.out.println("----------------Mostrando preguntas---------------");
		PreguntaDO aux;
		while(i.hasNext()) {
			aux=i.next();
			System.out.println("identificador:      "+aux.getId());
			System.out.println("pregunta:           "+aux.getPreg());
			System.out.println("respuesta 1:        "+aux.getR1());
			System.out.println("respuesta 2:        "+aux.getR2());
			System.out.println("respuesta 3:        "+aux.getR3());
			System.out.println("respuesta 4:        "+aux.getR4());
			System.out.println("respuesta correcta: "+aux.getrOk());
			System.out.println("--------------------------------------------------\n");
		}
	}
    
    public void listar(List<PreguntaDO> lista) {
		Iterator<PreguntaDO> i = lista.iterator();
		System.out.println("----------------Mostrando preguntas---------------");
		PreguntaDO aux;
		while(i.hasNext()) {
			aux=i.next();
			System.out.println("identificador:      "+aux.getId());
			System.out.println("pregunta:           "+aux.getPreg());
			System.out.println("respuesta 1:        "+aux.getR1());
			System.out.println("respuesta 2:        "+aux.getR2());
			System.out.println("respuesta 3:        "+aux.getR3());
			System.out.println("respuesta 4:        "+aux.getR4());
			System.out.println("respuesta correcta: "+aux.getrOk());
			System.out.println("--------------------------------------------------\n");
		}
	}
    
//-----------------------------------FUNCIONES AUXILIARES---------------------------------------
    
    public boolean existePregunta(String s, int resOk) {
    	try {
    		connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery("select * from preguntas where preguntas='"+s+"' and respcorrecta="+resOk);
            if(resultSet.next()) return true;
            else return false;
    	}
    	catch(Exception e){
            e.printStackTrace();
    		//System.out.println("No se pudo ejecutar existePregunta("+s+','+resOk+')');
    	}
		return false;
    }
    
    public int numPreguntas() {
    	int res=-1;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String cuenta="select count(id) from preguntas";
        	resultSet=statement.executeQuery(cuenta);
			if(resultSet.next()) {
	        	res=Integer.parseInt(resultSet.getString("count(id)"));
			}
			return res;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}finally {
            close();
    	}
    	return res;
    }
        
    public int idPregunta(String preg) {
    	int res=-1;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String consulta="select id from preguntas where preguntas='"+preg+'\'';
        	resultSet=statement.executeQuery(consulta);
            if(resultSet.next()){
            	res=Integer.parseInt(resultSet.getString("id"));
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}finally {
            close();
    	}
        return res;
    }
    
    public PreguntaDO crearP(String preg, String r1, String r2, String r3, String r4, int resOK) {
    	PreguntaDO nueva=new PreguntaDO();
    	try {
    		int id=numPreguntas() +1;
        	nueva.setId(id);
        	nueva.setPreg(preg);
        	nueva.setR1(r1);
        	nueva.setR2(r2);
        	nueva.setR3(r3);
        	nueva.setR4(r4);
        	nueva.setrOk(resOK);
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	return nueva;
    }
    
    public boolean esRespOk(int respCorrecta, int res) { //DEPENDE DE RESPONDER PREGUNTA Y DE COMO SE GUARDA LA RESPUESTA
    	boolean resul=false;
    	try {
    		if(respCorrecta==res) resul=true;
    		else resul=false;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	return resul;
    }
  
    //FUNCIONA
    public int idPreguntaRetoActual() {
    	int res=-1;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String consulta="select id from preguntas where id=(select idpreg from carteles where id=(select idcartel from retos where id=(select max(id) from retos)))";
        	resultSet=statement.executeQuery(consulta);
            if(resultSet.next())res=Integer.parseInt(resultSet.getString("id"));
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	finally {
            close();
    	}
        return res;
    }
    
    //FUNCIONA
    public int idRetoActual() {
    	int res=-1;
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String consulta="select max(id) from retos";
        	resultSet=statement.executeQuery(consulta);
        	if(resultSet.next()) {
	        	res=Integer.parseInt(resultSet.getString("max(id)"));
			}
            return res;
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	finally {
            close();
    	}
        return res;
    }
    
    //FUNCIONA
    public int[] PregRand(int pRA) {
    	try {
        	connect=ConnectionManager.getConnection();
            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
        	String consulta="select * from (select id from preguntas where id like '%' AND id!="+pRA+" order by dbms_random.value) where rownum <=4";
        	resultSet=statement.executeQuery(consulta);
            if(resultSet.next()) {
            	int[] enteros = new int[4];
                enteros[0]=Integer.parseInt(resultSet.getString("id"));
                resultSet.next();
                enteros[1]=Integer.parseInt(resultSet.getString("id"));
                resultSet.next();
                enteros[2]=Integer.parseInt(resultSet.getString("id"));
                resultSet.next();
                enteros[3]=Integer.parseInt(resultSet.getString("id"));
                return enteros;
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	finally {
            close();
    	}
		return null;
    }

    public int[] getPregsAdi(String idU) {
    	try {
	    	connect=ConnectionManager.getConnection();
	        // Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();
	        // Result set get the result of the SQL query
	    	String consulta="select idp1, idp2, idp3, idp4 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos)";
	    	resultSet=statement.executeQuery(consulta);
            if(resultSet.next()) {
            	int[] x = new int[4];
            	x[0]=Integer.parseInt(resultSet.getString("idp1"));
                x[1]=Integer.parseInt(resultSet.getString("idp2"));
                x[2]=Integer.parseInt(resultSet.getString("idp3"));
                x[3]=Integer.parseInt(resultSet.getString("idp4"));
                return x;
            }
    	}
    	catch (Exception e) {
            e.printStackTrace();
    	}
    	finally {
            close();
    	}
		return null;
    }


    public boolean mostrarRes(String idU, int idP) {
    	boolean resul=true;
    	try {
        	if(idP==idPreguntaRetoActual()) {
        		System.out.println("La pregunta corresponde a la del reto actual");
        		resul= false;
        	}
        	else {
        		connect=ConnectionManager.getConnection();
                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                // Result set get the result of the SQL query
            	String consulta="select idp1, idp2, idp3, idp4 from respuestasu where iduser='"+idU+"' and idreto=(select max(id) from retos)";
            	//System.out.println("La consulta a ejecutar es: "+consulta);
            	resultSet=statement.executeQuery(consulta); //NO DEVUELVE NADA PERO FUNCIONA EN DB
                if(resultSet.next()) {
		            int p1=Integer.parseInt(resultSet.getString("idp1"));
		            int p2=Integer.parseInt(resultSet.getString("idp2"));
		            int p3=Integer.parseInt(resultSet.getString("idp3"));
		            int p4=Integer.parseInt(resultSet.getString("idp4"));
		    		if(idP==p1 || idP==p2 || idP==p3 || idP==p4) {
		    			resul= false;
		    			//System.out.println("La respuesta corresponde a alguna asociada al reto actual");
		    		}
		    		//else System.out.printf("La pregunta respondida puede mostrar la respuesta y es distinta de %d, %d, %d, %d, %d\n",p1,p2,p3,p4,idP);
                }
                else {
                	//System.out.println("La consulta no ha devuelto nada");
                }
        	}
    	} catch (Exception e) {
            e.printStackTrace();
    	}finally {
            close();
    	}
    	return resul;
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