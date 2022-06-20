// Buttons listeners
$(document).ready(function () {
    $("#send").click(function () {
        ajaxCall('currency', 'GET', 'ajaxform', 'resultsContent');
    });
});

function ajaxCall(methodUrl, type, formId, resultDiv) {

    var callUrl = contextPath + methodUrl;

    clearDiv(resultDiv);

    var dataForm = null;
    if (formId != null) {
        dataForm = $('#' + formId).serializeArray();
    }

    $.ajax({
        url: callUrl,
        type: type,
        data: dataForm,
        success: function (responseText) {
            $('#' + resultDiv).html(responseText);
        },
        error: function (responseText) {
            try {
                responseText.responseText = responseText.responseText.replace(/(&quot\;)/g, "'");
            } catch (err) {
            }
            var jsonString = JSON.stringify(responseText, null, 4);
            $('#' + resultDiv).html(syntaxHighlight(jsonString));
        }
    });
}

function clearDiv(resultDiv) {
    $('#' + resultDiv).html(createLoadingDiv());
}

function createLoadingDiv() {
    return '<div class="loader"><div> Loading </div><div></div><div></div><div></div><div></div><div></div><div></div></div>';
}

function syntaxHighlight(json) {
    json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
        var cls = 'number';
        if (/^"/.test(match)) {
            if (/:$/.test(match)) {
                cls = 'key';
            } else {
                cls = 'string';
            }
        } else if (/true|false/.test(match)) {
            cls = 'boolean';
        } else if (/null/.test(match)) {
            cls = 'null';
        }
        return '<span class="' + cls + '">' + match + '</span>';
    });
}
