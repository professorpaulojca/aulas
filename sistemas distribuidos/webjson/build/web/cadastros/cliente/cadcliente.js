$(document).ready(function() {
   
    enchesexo();
    
    function enchesexo(){        
        //fazer a chamado da servlet
        $.ajax({
            url: '/webjson/ctrlSexo', //lugar onde a servlet está
            type: 'POST',
            data: {
                oper: "1"
            },
            complete: function (e, xhr, result) {
                if (e.readyState == 4 && e.status == 200) {
                    try { //Converte a resposta HTTP JSON em um objeto JavaScript
                        var Obj = eval("(" + e.responseText + ")");
                    }
                    catch (err) { //
                        // Mostra Aviso
                        alert("Algo de errado aconteceu!");
                    }
                    if (Obj != null) {

                        for (var i = 0; i < Obj.length; i++) {
                            $("#cmbsexo").append("<option value='" + Obj[i].id + "'>" + Obj[i].descricao + "</option>");
                        }
                    }
                }

            }
        });
        
    }
    
    
});