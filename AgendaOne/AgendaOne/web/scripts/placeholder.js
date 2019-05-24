$(document).ready(function(){
       $('.J_place').each(function(){
            var place = $(this).attr('title');

            var input = $(this);

            input
                    .val(place)
                    .css('color','#888')
                    .focusin(function(){
                        input.css('color','#222');
                        if(input.val()==place){
                            input.val('');  
                        }

                    }).focusout(function(){
                        if(input.val()==''){
                            input.css('color', '#888');
                            input.val(place);
                        }
                    });

        }); 
   


});
