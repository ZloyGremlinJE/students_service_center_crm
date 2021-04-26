$(function () {
    const requestURL = 'http://localhost:8080/api/users';
    const buttonAdd = $('#addUserBtn');
    const pRole = $('#roleList');
    let jData = {};
    jData['organizationId'] = organizationId;
    for (i = 0; i < listRoles.length; i++) {
        if (i === 0) {
            $('<input type="radio" value="' + listRoles[i] + '" name="roles" id="'+
                listRoles[i] +'" checked/><label class="m-1" for="'+ listRoles[i] +'">' +
                listRoles[i] + '</label>').appendTo(pRole)

        } else {
            $('<input type="radio" value="' + listRoles[i] + '" name="roles" id="' +
                listRoles[i] + '"/><label class="m-1" for="' + listRoles[i] + '">' +
                listRoles[i] + '</label>').appendTo(pRole)
        }
    }

    buttonAdd.on('click',function () {
        $('#formAddUser').find('input').each(function () {
            if((this.id != 'addUserBtn') && (this.id != 'cancelBtn')) {
                if (this.name === 'roles') {
                    if ($(this).is(':checked')) {
                        jData['role'] = $(this).val();
                    }
                } else {
                    jData[this.name] = $(this).val();
                }
            }
        });
        sendRequestPost('POST', requestURL, jData).then(data => {
            let div = $('#emailInfo').empty();
            $('#firstName').val("");
            $('#lastName').val("");
            $('#username').val("");
            $('#password').val("");
            if (data === "IM_USED") {
                $('<div class="container text-danger">Этот e-mail уже используется</div>').appendTo(div);
            }
            if (data[1] === 400) {
                data[0].then(data => {
                    for (let key of Object.keys(data)) {
                        $('<div class="container text-danger">' + data[key] + '</div>').appendTo(div);
                    }
                });

            }
        });
    });

})