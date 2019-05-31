package Practica2;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import Practica2.Estudiante;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Template {

    public void manejoTemplate(){
        TemplateFreeMaker();
    }

    public void TemplateFreeMaker(){
        //Indicar la ruta del FreeMaker!!!
        staticFiles.location("/public");
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Template.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);
        List<Estudiante> listaEstudiante = new ArrayList<>();
        /*Formulario en
        *http://localhost:4567/formulario
         */
        get("/formulario", (request, response)->{
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario de Edgar en FreeMaker");
            return new ModelAndView(attributes, "Form1.ftl");
        }, freeMarkerEngine);

        /*
        //http://localhost:4567/datosEstudiantes/20150166
         */
        get("/datosEstudiantes/:matricula", (request, response) ->
        {
            Estudiante estudiante = new Estudiante(Integer.parseInt(request.params("matricula")), "Nombre", "Apellido", "Carrera", "Telefono");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "datosEstudiantes.ftl");
        }, freeMarkerEngine);

        /*
         * http://localhost:4567/ProcesarFormulario/
         */
        post("/ProcesarFormulario/",(request, response) -> {
            int matricula = Integer.parseInt(request.queryParams("matricula"));
            String nombre = request.queryParams("nombre");
            String apellido = request.queryParams("apellido");
            String carrera = request.queryParams("carrera");
            String telefono = request.queryParams("telefono");

            listaEstudiante.add(new Estudiante(matricula, nombre, apellido, carrera, telefono));

            Map<String, Object> attributes = new HashMap<>();
            //enviando los parametros a la vista.
            response.redirect("/formulario");
            return "";
        });

        get("/Datosprocesado",(request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("listaEstudiante", listaEstudiante);
            return new ModelAndView(attributes, "FormularioProcesado.ftl");
        } ,freeMarkerEngine);

//        Eliminar estudiante
//        Debo recibir desde Datosprocesado para Poder mostrar los Datos y cuando elimino vuelvo a cargar el mismo ftl**
        post("/Datoseliminado/:matricula",(request, response) -> {
            System.out.println(request.params("matricula"));
            int contador = 0;
            int matricula = Integer.parseInt(request.params("matricula"));
            for(Estudiante estudiante : listaEstudiante){
                if(estudiante.getMatricula() == matricula){
                    listaEstudiante.remove(estudiante);
                }
                contador++;
            }
            response.redirect("/Datosprocesado");
            return "";
        });


    }
}
