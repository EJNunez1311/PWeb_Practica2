<!DOCTYPE html>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <#--    <title>${titulo}</title>-->
    <style>
        body{
            background: -webkit-linear-gradient(left, #0072ff, #00c6ff);
        }
        .contact-form{
            background: #fff;
            margin-top: 10%;
            margin-bottom: 5%;
            width: 70
        }
        .contact-form .form-control{
            border-radius:1rem;
        }
        .contact-image{
            text-align: center;
        }
        .contact-image img{
            border-radius: 6rem;
            width: 11%;
            margin-top: -3%;
            transform: rotate(29deg);
        }
        .contact-form form{
            padding: 14%;
        }
        .contact-form form .row{
            margin-bottom: -7%;
        }
        .contact-form h3{
            margin-bottom: 8%;
            margin-top: -10%;
            text-align: center;
            color: #0062cc;
        }
        .contact-form .btnContact {
            width: 50%;
            border: none;
            border-radius: 1rem;
            padding: 1.5%;
            background: #dc3545;
            font-weight: 600;
            color: #fff;
            cursor: pointer;
        }
        .btnContactSubmit
        {
            width: 50%;
            border-radius: 1rem;
            padding: 1.5%;
            color: #fff;
            background-color: #0062cc;
            border: none;
            cursor: pointer;
        }
    </style>
</head>

<div class="container contact-form">
    <div class="contact-image">
        <img src="https://image.ibb.co/kUagtU/rocket_contact.png" alt="rocket_contact"/>
    </div>
    <form action="/DatosEdit" method="post">
        <h3>Formulario Web</h3>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <input type="number" name="matricula" class="form-control" placeholder="Matricula" value="${"matricula"}" />
                </div>
                <div class="form-group">
                    <input type="text" name="nombre" class="form-control" placeholder="Nombre" value="${"nombre"}" />
                </div>
                <div class="form-group">
                    <input type="text" name="apellido" class="form-control" placeholder="Apellido" value="${"Apellido"}" />
                </div>
                <div class="form-group">
                    <input type="submit" name="btnSubmit" class="btnContact" value="Guardar"/>
                    <a href="/Datosprocesado"  class="btnContact" >Listo</a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" name="carrera" class="form-control" placeholder="Carrera" value="${"carrera"}"/>
                </div>
                <div class="form-group">
                    <input type="text" name="telefono" class="form-control" placeholder="Telefono" value="${"telefono"}"/>
                </div>
                <div class="form-group">

                </div>
            </div>
        </div>
    </form>



</div>