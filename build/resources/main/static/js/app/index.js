var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });

        $('#btn-update').on('click', function () {
            _this.update();
        });

        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            device_nm: $('#device_nm').val(),
            serial_no: $('#serial_no').val(),
            latitude: $('#latitude').val(),
            longitude: $('#longitude').val()
            //loadage: $('#loadage').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('쓰레기통이 등록되었습니다.');
            window.location.href = '/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
        var data = {
            device_nm: $('#device_nm').val(),
            serial_no: $('#serial_no').val(),
            latitude: $('#latitude').val(),
            longitude: $('#longitude').val()
            //location: $('#location').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/posts/'+id,//어떤 것을 수정할지 URL Path로 구분하기 위해 Path에 id 추가
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('쓰레기통이 수정되었습니다.');
            window.location.href = '/list';  //글 등록 성공하면 list 페이지로
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('쓰레기통이 삭제되었습니다.');
            window.location.href = '/list';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();