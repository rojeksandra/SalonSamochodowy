function edit row(no){
    document.getElementById("edit_button"+no).style.display="none";
    document.getElementById("save_button"+no).style.display="block";
    var id_pojazdu= document.getElementById("id_pojazdu_row"+no);
    var numer_vin =document.getElementById("numer_vin_row"+no);
    var marka=document.getElementByld("marka_row"+no);
    var id_pojazdu_data=id_pojazdu.innerHTML;
    var numer_vin_data =numer_vin.innerHTML;
    var marka_data=marka.innerHTML;  id_pojazdu.innerHTML="<input type='text' id='id_pojazdu_text"+no+" ' value='"+id_pojazdu_data + ">

    function save_row(no) {
        var id_pojazdu_val= document.getElementById('id_pojazdu_text' +no).value;
        var numer_vin_val=document.getElementById("numer_vin_text"+no).value;
        var marka_val=document.getElementById("marka_text"+no).value;
        document.getElementById("id_pojazdu_row"+no).innerHTML=id_pojazdu_val;
        document.getElementById("numer_vin_row"+no).innerHTML=numer_vin_val;
        document.getElementById("marka_row"+no).innerHTML=marka_val;
        document.getElementById("edit_button"+no).style.display="block";
        document.getElementById("save_button"+no).style.display="none";
    }
    function delete_row(no){
        document.getElementById("row"+no+"").outerHTML="";
    }
    function add_row(){
        var new_id_pojazdu=document.getElementById("new_id_pojazdu").value;
        var new_numer_vin=document.getElementById("new_numer_vin").value;
        var new_marka=document.getElementById("new_marka").value;
        var table=document.getElementById("data_table");
        var table_len=(table.rows.length)-1;
        var row=table.insertRow(table_len).outerHTML="<tr id='row"+table_len"'><td id='id_pojazdu_row"+table_len+"'>"+new_id_pojazdu+"</td><td id='numer_vin_row"+table_len+"'>"+new_numer_vin+"</td><td id='marka_row"+table_len+"'>"+new_marka+"</td><td> <input type='button' id='edit_button"+table_len+"' value='edit' class='edit' onclick='edit_row("+table_len+")'><input type='button' id='save_button"+table_len+"' value='save' class='save' onclick='save_row("+table_len+")'><input type='button' id='delete_button"+table_len+"' value='delete' class='delete' onclick='delete_row("+table_len+")'></td></tr>";
        document.getElementById("new_id_pojazdu").value="";
         document.getElementById("new_numer_vin").value="";
          document.getElementById("new_marka").value="";
    }
}



