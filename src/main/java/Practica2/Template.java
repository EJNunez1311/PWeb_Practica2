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
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(Template.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        /*Formulario en
        *http://localhost:4567/formulario/
         */
        get("/formulario", (request, response)->{
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Formulario de Edgar en FreeMaker");
            return new ModelAndView(attributes, "formulario.ftl");
        }, freeMarkerEngine);

        /*
        //http://localhost:4567/datosEstudiante/20150166
         */
        get("/datosEstudiante/:matricula", (request, response) ->
        {
            Estudiante estudiante = new Estudiante(Integer.parseInt(request.params("matricula")), "Estudiante", "Carrera", "Telefono");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "datosEstudiante.ftl");
        }, freeMarkerEngine);
    }
}
