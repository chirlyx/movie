(function () {
    'use strict';
    window.addEventListener('load', () => {
        var forms = document.getElementsByClassName('needs-validation');
        var textarea = document.getElementById('createDescription');
        var regexp = /^[a-zA-Z0-9 .,]{4,35}$/;
        textarea.addEventListener('change', (e) => {
            const str = e.target.value;
            if (!regexp.test(str)) {
                textarea.classList.remove('valid');
                textarea.classList.add('invalid');
            } else {
                textarea.classList.remove('invalid');
                textarea.classList.add('valid');
            }
        })
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();