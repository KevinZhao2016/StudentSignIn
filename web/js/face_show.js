$(function () {
    var video = document.getElementById('video');
    var canvas = document.getElementById('canvas');
    var context = canvas.getContext('2d');
    var tracker = new tracking.ObjectTracker('face');
    tracker.setInitialScale(4);
    tracker.setStepSize(2);
    tracker.setEdgesDensity(0.1);
    tracking.track('#video', tracker, {camera: true});
});
$(function () {
    $("#take_photo").click(function () {
        var video = document.getElementById('video');
        var canvas = document.getElementById('canvas');
        var context = canvas.getContext('2d');
        var clear = document.getElementById('clear');
        context.drawImage(video,0,0,580,436);
        canvas.style.display="block";
        clear.style.display="block";
        this.value="重新拍照";

    });
});
function check_sub() {
    var canvas = document.getElementById('canvas');
    var imgStr0 = canvas.toDataURL("image/png");
    imgStr =  imgStr0.substring(imgStr0.indexOf(",")+1);
    document.getElementById('face').value=imgStr;
    return true;
}