function verify() {
    console.log(document.getElementById("#numero_sala"));
    if (document.getElementById("#numero_sala") == undefined || document.getElementById("#numero_sala") == "") {
        alert("O número da sala não pode estar em branco");
        return false;
    }
    if (document.getElementById("#capacidade") == undefined || document.getElementById("#capacidade") == "") {
        alert("A capacidade não pode estar em branco");
        return false;
    }
}
