function validaForm(){
             d = document.cadastro;
            //validar Usuario
           if (d.usuario.value == ""){
                  alert("O campo Usuário deve ser preenchido!");
                  d.usuario.focus();
                return false;
           }
          //validar Senha
           if (d.senha.value == ""){
                   alert("O campo Senha deve ser preenchido!");
                   d.senha.focus();
                return false;
           }

          //validar Nome
           if (d.nome.value == ""){
                    alert("O campo Nome deve ser preenchido!");
                    d.nome.focus();
               return false;
           }
          

           //validar email
          if (d.email.value == ""){
                     alert("O campo Email deve ser preenchido!");
                     d.email.focus();
                     return false;
         }
         //validar email(verificao de endereco eletrônico)
         parte1 = d.email.value.indexOf("@");
         parte3 = d.email.value.length;
         if (!(parte1 >= 3 && parte3 >= 9)) {
                     alert ("O campo EMAIL deve ser conter um endereco eletronico!");
                     d.email.focus();
                     return false;
         }if (d.mensagem.value == ""){
                     alert("Digite uma mensagem!");
                     return false;
                     d.mensagem.focus();
           }
        
document.cadastro.submit();
         
}

