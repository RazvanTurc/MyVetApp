$(document).ready(() => {

    // validate Text function
    function valid(string) {

        if(string === ""){
            string = "N/A";
            return string;
        } else {
            return string;
        }

    }

    // ADD
    $('.add-icon').click(function () {
        const appointmentId = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const time = row.children[0].textContent;

        $('#add-appointment-button').click(function () {
            const pet = $('#modal-pet').val();
            const owner = $('#modal-owner').val();
            const vet = $('#modal-vet').val();

            const newAppointment = {
                preciseTime: time,
                vet: valid(vet),
                pet: valid(pet),
                owner: valid(owner)
            };

                alert(JSON.stringify({
                    pet,
                    owner,
                    vet
                }));

            fetch('appointment/' + appointmentId, {
                method: 'PUT',
                body: JSON.stringify(newAppointment),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    alert("There are errors " + response.status)
                }
            });
        });
        $('#close-button').click(function () {
            location.reload();
        })
    });

    // EDIT
    $('.edit-icon').click(function () {
        const appointmentId = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const time = row.children[0].textContent;
        const pet = row.children[1].innerText;
        const owner = row.children[2].innerText;
        const vet = row.children[3].innerText;

        $('#modal-pet').val(pet);
        $('#modal-owner').val(owner);
        $('#modal-vet').val(vet);

        $('#add-appointment-button').click(function () {
            const pet = $('#modal-pet').val();
            const owner = $('#modal-owner').val();
            const vet = $('#modal-vet').val();

            const newAppointment = {
                preciseTime: time,
                vet: valid(vet),
                pet: valid(pet),
                owner: valid(owner)
            };

            fetch('appointment/' + appointmentId, {
                method: 'PUT',
                body: JSON.stringify(newAppointment),
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(response => {
                if (response.ok) {
                    location.reload();
                } else {
                    alert("There are errors " + response.status)
                }
            });
        });
        $('#close-button').click(function () {
            location.reload();
        })
    });

// DELETE
    $('.delete-icon').click(function () {
        const appointmentId = this.parentElement.id;

        fetch('appointment/' + appointmentId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });




    //CLEAR DATA from MODAL
    function clearModal() {
        $('#modal-description').val('');
        $('#modal-amount').val('');
        $('#modal-type').val('');
    }

    //end
});
