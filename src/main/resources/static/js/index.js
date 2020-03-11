let COUNT_FOR_NUMBER_OF_ROWS = 1;

let MAIN_INPUT_GROUP = undefined;
let CAN_CALL_API = true;
let responseData = undefined;
let currentSelectedItem = undefined;

let focusedNode = undefined;
let parentOfFocusedNode = undefined;
let userQueriedValue = undefined;
let previewOfCut = undefined;

let colorsInput = undefined;
let colorsPreview = undefined;

let sizeInput = undefined;
let sizePreview = undefined;

let priceElement = undefined;



enterPressed();


function enterPressed() {
  let inputGroup = document.getElementById("main-input-group");

  inputGroup.addEventListener("keyup", (data) => {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
      // Cancel the default action, if needed
      event.preventDefault();
      // Trigger the button element with a click
      console.log("Enter Key Pressed");


      addNewInputToInputGroup();

    } else {

      if (CAN_CALL_API) {

        CAN_CALL_API = false;

        focusedNode = data.srcElement;
        parentOfFocusedNode = data.srcElement.parentNode;
        console.log("parent of input");
        console.log(parentOfFocusedNode)


        MAIN_INPUT_GROUP = parentOfFocusedNode.parentNode;
        console.log("parent of parents input")
        console.log(MAIN_INPUT_GROUP);

        colorsInput = MAIN_INPUT_GROUP.childNodes[5].childNodes[1];
        console.log(colorsInput);
        colorsPreview = MAIN_INPUT_GROUP.childNodes[5].childNodes[3];

        userQueriedValue = focusedNode.value;
        previewOfCut = parentOfFocusedNode.childNodes[3];

        if (previewOfCut.hasChildNodes()) {
          previewOfCut.innerHTML = "";
        }

        previewOfCut.style.display = "block";

        let array = userQueriedValue.split(" ");

        var isNum = /^\d+$/.test(array[0]);

        if (isNum) {
          getCutsStringMatch(array[0]);
        }
        else {
            console.log("No Number to parse");
            CAN_CALL_API = true;
        }

      } else {
        console.log("COULD NOT CALL API");
      }
    }
  });
}

$("input").focus(function (event) {
  //  $(this).css("background-color", "#cccccc");

  console.log("focusing");
  focusedNode = event.currentTarget;

});

// Get preview selection
// get child from preview div
$(document).ready(function () {
  $('.item-preview').on('click', function (event) {
    // event.stopPropagation();
    const question = event.target.innerHTML;

    const splitQuestion = question.split(" ");
    currentSelectedItem = responseData[splitQuestion[0]]

    setupColorSection();



    // get search and set search bar
    const search = document.getElementById('searchInput');
    focusedNode.value = question;
    previewOfCut.style.display = "none";

    focusedNode = colorsInput;
  });
});


$(document).ready(function () {
  $('.color-preview').on('click', function (event) {
    // event.stopPropagation();
    const selectedColor = event.target.innerHTML;

    // focusedNode.value = question;
    colorsPreview.style.display = "none";
    focusedNode.value = selectedColor;
  });
});


function testServer() {
  console.log("Calling server for test");
  axios.get("/test").then((response) => {


  });
}

function getCutsStringMatch(string) {
  axios.get("json/cuts/cuts/" + string).then((response) => {
    responseData = response.data
    return response.data;
  })
    .then(addResponseToPreview);
}

function addResponseToPreview(response) {
  // append to preview
  for (var property in response) {
    if (response.hasOwnProperty(property)) {
      let completeString = property + " " + response[property]["description"];

      let addToPreview = document.createElement("div");
      addToPreview.classList.add("item-preview-item");
      addToPreview.innerHTML = completeString;
      previewOfCut.appendChild(addToPreview);
    }
  }
  CAN_CALL_API = true;

}

function addNewInputToInputGroup() {

  // get main input group
  let inputGroupContainer = document.getElementById("main-input-group");

  let inputGroup = document.createElement("div");
  inputGroup.classList.add("input-group");

  // crearte the prepend divs
  let prependDiv = document.createElement("div");
  let span = document.createElement("span");

  //prepend gets the span
  prependDiv.classList.add("input-group-prepend");
  prependDiv.classList.add("mb-1");
  span.classList.add("input-group-text");

  COUNT_FOR_NUMBER_OF_ROWS++;
  span.innerHTML = COUNT_FOR_NUMBER_OF_ROWS;

  prependDiv.appendChild(span);

  //input group gets the prepend
  inputGroup.appendChild(prependDiv);



  // required inputs for item, color, size, quantity, price

  // item
  let itemInput = document.createElement("input");
  itemInput.classList.add("form-control");
  itemInput.classList.add("mb-1");
  itemInput.setAttribute("type", "text");
  itemInput.placeholder = "item"

  //color
  let colorInput = document.createElement("input");
  colorInput.classList.add("form-control");
  colorInput.classList.add("mb-1");
  colorInput.setAttribute("type", "text");
  colorInput.placeholder = "color"

  //size
  let sizeInput = document.createElement("input");
  sizeInput.classList.add("form-control");
  sizeInput.classList.add("mb-1");
  sizeInput.setAttribute("type", "text");
  sizeInput.placeholder = "size"

  // quantity
  let quantityInput = document.createElement("input");
  quantityInput.classList.add("form-control");
  quantityInput.classList.add("mb-1");
  quantityInput.setAttribute("type", "text");
  quantityInput.placeholder = "size"


  //price
  let priceInput = document.createElement("input");
  priceInput.classList.add("form-control");
  priceInput.classList.add("mb-1");
  priceInput.setAttribute("type", "text");
  priceInput.placeholder = "$"




  inputGroup.appendChild(itemInput);
  inputGroup.appendChild(colorInput);
  inputGroup.appendChild(quantityInput);
  inputGroup.appendChild(priceInput);

  inputGroupContainer.appendChild(inputGroup);
}

function setupColorSection(){
    console.log("Setting up color section");

    // setup the colors preview div
    console.log("looping through colors");
    currentSelectedItem.colors.forEach((color) => {

        let colorDiv = document.createElement("div");
        colorDiv.innerHTML = color;
        colorsPreview.appendChild(colorDiv);
    });

    colorsPreview.style.display = "block";
 }