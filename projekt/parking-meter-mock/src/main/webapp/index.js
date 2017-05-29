$(function () {
    $('#getTicketButton').click(function () {
        var parkingMeterId = $('#parkingMeterId').val();
        var minutes = $('#minutes').val();
        var expirationTime = new Date($.now());
        expirationTime.setMinutes(expirationTime.getMinutes() + minutes);
        var url = "http://localhost:8080/parking-area-service/rest/ticket";
        var data = {
            'expirationTime': expirationTime,
            'parkingMeter': {
                'id': parkingMeterId
            }
        };

        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json',
            dataType: 'json',
            data: JSON.stringify(data),
            success: function () {
                console.log('success');
            }
        });
    });
});