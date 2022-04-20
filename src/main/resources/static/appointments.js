$(document).ready(() => {

    // $('#add-appointment-button').click(function () {
    //     const appointmentId = this.parentElement.id;
    //     const time = $('#modal-time option:selected').text();
    //     const pet = $('#modal-pet').val();
    //     const owner = $('#modal-owner').val();
    //     const vet = $('#modal-vet').val();
    //
    //     const newAppointment = {
    //         id: appointmentId,
    //         time: time,
    //         vet: vet,
    //         pet: pet,
    //         owner: owner
    //     };
    //
    //     alert(JSON.stringify({
    //         appointmentId,
    //         time,
    //         pet,
    //         owner,
    //         vet
    //     }));
    //
    //     fetch('appointment/' + appointmentId, {
    //         method: 'PUT',
    //         body: JSON.stringify(newAppointment),
    //         headers: {
    //             'Content-Type': 'application/json'
    //         }
    //     }).then(response => {
    //         if (response.ok) {
    //             location.reload();
    //         } else {
    //             alert("There are errors " + response.status)
    //         }
    //     });
    // });

    $('.add-icon').click(function () {
        const appointmentId = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const time = row.children[0].innerText;

        $('#add-appointment-button').click(function () {
            // const time = $('#modal-time option:selected').text();
            const pet = $('#modal-pet').val();
            const owner = $('#modal-owner').val();
            const vet = $('#modal-vet').val();

            const newAppointment = {
                time: time,
                vet: vet,
                pet: pet,
                owner: owner
            };

            alert(JSON.stringify({
                appointmentId,
                time,
                pet,
                owner,
                vet
            }));

            fetch('appointment/', {
                method: 'POST',
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
    });


    $('.edit-icon').click(function () {
        const appointmentId = this.parentElement.id;
        const row = this.parentElement.parentElement;
        const pet = row.children[1].innerText;
        const owner = row.children[2].innerText;
        const vet = row.children[3].innerText;

        // const newAppointment = {
        //     id : appointmentId,
        //     pet : pet,
        //     owner : owner,
        //     vet : vet
        // };
        alert(JSON.stringify({
            appointmentId,
            pet,
            owner,
            vet
        }));
    });


    $('.delete-icon').click(function () {
        const appointmentId = this.parentElement.id;

        alert(JSON.stringify({
            appointmentId
        }));

        fetch('appointment/' + appointmentId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });

    //end
});
