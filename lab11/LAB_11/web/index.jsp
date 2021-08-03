<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-4 mt-5">
            <p><b>TASK 1</b></p>
            <form>
                <div class="form-group">
                    <input type="number" name="Value-x" class="form-control" id="task1x" placeholder="X">
                </div>
                <div class="form-group">
                    <input type="number" name="Value-y" class="form-control" id="task1y" placeholder="Y">
                </div>
                <div class="form-group">
                    <input type="number" READONLY class="form-control" id="task1z" placeholder="Z">
                </div>
                <br/>
                <button type="submit" id="btn-submit-t1" class="btn btn-primary btn-submit-t1">Submit</button>
            </form>


            <p><b>TASK 2 (XML), 3 (JSON)</b></p>
            <form>
                <div class="form-group">
                    <input type="number" name="XRand-N" class="form-control" id="task2z" placeholder="Z">
                </div>
                <div class="form-group">
                    <input type="text" READONLY class="form-control" id="task2randomInts" placeholder="Z">
                </div>
                <br/>
                <button type="submit" id="btn-submit-t2" class="btn btn-primary">Submit (XML)</button>
                <button type="submit" id="btn-submit-t3" class="btn btn-primary">Submit (JSON)</button>

            </form>


            <p><b>TASK 4 </b></p>
            <input value="Async" class="btn btn-primary mb-2" type="button"
                   onclick="sendXMLHTTPRequest({isAsyncRequest: true})">
            <input value="Sync" class="btn btn-primary mb-2" type="button"
                   onclick="sendXMLHTTPRequest({isAsyncRequest: false})"><br/>

            <input type="text" style="margin-top: 15px" READONLY class="form-control" id="task4a" placeholder="SUM">
            <input type="text" READONLY class="form-control" id="task4b" placeholder="XML">
            <input type="text" READONLY class="form-control" id="task4c" placeholder="JSON">

            <p><b>TASK 5</b></p>
            <button type="submit" id="btn-submit-t5" class="btn btn-primary btn-submit-t1">Jquery</button>


        </div>
    </div>
</div>
</body>


<script>
    //TASK 1
    document.getElementById("btn-submit-t1").addEventListener("click", function (event) {
        event.preventDefault()

        let xhr = new XMLHttpRequest();

        xhr.open('GET', '/LAB_11_war_exploded/SssHeader');
        xhr.setRequestHeader("Value-x", document.querySelector("#task1x").value);
        xhr.setRequestHeader("Value-y", document.querySelector("#task1y").value);

        xhr.send();

        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                document.querySelector("#task1z").value = xhr.getResponseHeader("Value-z");
            }
        };

        xhr.onprogress = function (event) {
            if (event.lengthComputable) {
                console.log('onProgress');
            }
        };

        xhr.onerror = function () {
            alert("Запрос не удался");
        };

    });

    //TASK 2
    document.getElementById("btn-submit-t2").addEventListener("click", function (event) {
        event.preventDefault()

        let xhr = new XMLHttpRequest();

        xhr.open('GET', '/LAB_11_war_exploded/SssXml');
        xhr.setRequestHeader("XRand-N", document.querySelector("#task2z").value);

        xhr.send();

        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                console.log(stringifyXML(xhr));
                document.querySelector("#task2randomInts").value = stringifyXML(xhr).toString();
            }
        };

        xhr.onprogress = function (event) {
            if (event.lengthComputable) {
                console.log('onProgress');
            }
        };

        xhr.onerror = function () {
            alert("Запрос не удался");
        };

    });

    //TASK 3
    document.getElementById("btn-submit-t3").addEventListener("click", function (event) {
        event.preventDefault()

        let xhr = new XMLHttpRequest();

        xhr.open('GET', '/LAB_11_war_exploded/SssJson');
        xhr.setRequestHeader("XRand-N", document.querySelector("#task2z").value);

        xhr.send();

        xhr.onreadystatechange = () => {
            if (xhr.readyState === 4) {
                console.log(stringifyJSON(xhr));
                document.querySelector("#task2randomInts").value = stringifyJSON(xhr).toString();
            }
        };

        xhr.onprogress = function (event) {
            if (event.lengthComputable) {
                console.log('onProgress');
            }
        };

        xhr.onerror = function () {
            alert("Запрос не удался");
        };

    });

    //TASK 4
    function sendXMLHTTPRequest({isAsyncRequest}) {

        let xhr1 = new XMLHttpRequest();

        xhr1.open('GET', '/LAB_11_war_exploded/SssHeader', isAsyncRequest);
        xhr1.setRequestHeader("Value-x", document.querySelector("#task1x").value);
        xhr1.setRequestHeader("Value-y", document.querySelector("#task1y").value);

        xhr1.send();

        if (isAsyncRequest) {
            xhr1.onreadystatechange = () => {
                if (xhr1.readyState === 4) {
                    document.querySelector("#task4a").value = xhr1.getResponseHeader("Value-z");
                }
            };
            xhr1.onprogress = function (event) {
                if (event.lengthComputable) {
                    console.log('onProgress');
                }
            };

            xhr1.onerror = function () {
                alert("Request error");
            };
        } else {
            if (xhr1.status === 200) document.querySelector("#task4a").value = xhr1.getResponseHeader("Value-z");
        }

        let xhr2 = new XMLHttpRequest();

        xhr2.open('GET', '/LAB_11_war_exploded/SssXml', isAsyncRequest);
        xhr2.setRequestHeader("XRand-N", document.querySelector("#task2z").value);

        xhr2.send();

        if (isAsyncRequest) {
            xhr2.onreadystatechange = () => {
                if (xhr2.readyState === 4) {
                    document.querySelector("#task4b").value = "XML " + stringifyXML(xhr2).toString();
                }
            };

            xhr2.onprogress = function (event) {
                if (event.lengthComputable) {
                    console.log('onProgress');
                }
            };

            xhr2.onerror = function () {
                alert("Запрос не удался");
            };
        } else {
            if (xhr2.status === 200) document.querySelector("#task4b").value = "XML " + stringifyXML(xhr2).toString();
        }

        let xhr3 = new XMLHttpRequest();

        xhr3.open('GET', '/LAB_11_war_exploded/SssJson', isAsyncRequest);
        xhr3.setRequestHeader("XRand-N", document.querySelector("#task2z").value);

        xhr3.send();

        if (isAsyncRequest) {
            xhr3.onreadystatechange = () => {
                if (xhr3.readyState === 4) {
                    document.querySelector("#task4c").value = "JSON " + stringifyJSON(xhr3).toString();
                }
            };

            xhr3.onprogress = function (event) {
                if (event.lengthComputable) {
                    console.log('onProgress');
                }
            };

            xhr3.onerror = function () {
                alert("Запрос не удался");
            };
        } else {
            if (xhr3.status === 200) document.querySelector("#task4c").value = "JSON " + stringifyJSON(xhr3).toString();
        }

    }

    //TASK 5
    document.getElementById("btn-submit-t5").addEventListener("click", function (event) {
        $.ajax({
            url: "/LAB_11_war_exploded/SssJson",
            type: 'GET',
            headers: {
                'XRand-N': document.querySelector("#task2z").value
            },
            contentType: 'application/json; charset=utf-8',
            success: function (result) {
                alert(result)
                alert(result.responseText)
                alert(JSON.parse(result.responseText)['res'])
            },
            error: function (error) {
                alert(JSON.parse(error.responseText)['res'])
            }
        });
    });


    function stringifyXML(req) {
        const xmlDoc = req.responseXML;
        const arr = Array.from(xmlDoc.getElementsByTagName("num"));
        return arr.map(number => number.innerHTML).join(" ");
    }

    function stringifyJSON(req) {
        const arr = JSON.parse(req.responseText);
        return arr.res.join(' ');
    }


</script>
</html>
