let COUNT = 1;

let MAIN_INPUT_GROUP = undefined;

let focusedNode = undefined;
let parentOfFocusedNode = undefined;
let userQueriedValue = undefined;
let responseData = undefined;
let previewOfCut = undefined;

let colorsInput = undefined;
let colorsPreview = undefined;

let sizeInput = undefined;
let sizePreview = undefined;

let priceElement = undefined;



enterPressed();


function enterPressed(){
  let inputGroup = document.getElementById("main-input-group");

  inputGroup.addEventListener("keyup", (data) => {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
      // Cancel the default action, if needed
      event.preventDefault();
      // Trigger the button element with a click
      console.log("Enter Key Pressed");
    

      addNewInputToInputGroup();
  
    }else {

     
      focusedNode = data.srcElement;
      parentOfFocusedNode = data.srcElement.parentNode;

      MAIN_INPUT_GROUP = parentOfFocusedNode.parentNode;

     colorsInput = MAIN_INPUT_GROUP.childNodes[5].childNodes[1];
     colorsPreview = MAIN_INPUT_GROUP.childNodes[5].childNodes[3];

     console.log("INPUT");
     console.log(colorsPreview);


      console.log(MAIN_INPUT_GROUP);

      userQueriedValue = focusedNode.value;
      previewOfCut = parentOfFocusedNode.childNodes[3];


      if (previewOfCut.hasChildNodes()){
          previewOfCut.innerHTML = "";
      }

      previewOfCut.style.display = "block";
      
      let array = userQueriedValue.split(" ");

      var isNum = /^\d+$/.test(array[0]);

      if(isNum){
        getCutsStringMatch(array[0]);
      }
       
    }
  });
}

$("input").focus(function(event){
//  $(this).css("background-color", "#cccccc");

});

// Get preview selection
// get child from preview div
$(document).ready(function() {
  $('.search-bar-results').on('click', function(event) {
      // event.stopPropagation();
      const question = event.target.innerHTML;

       // get search and set search bar
       const search = document.getElementById('searchInput');
       focusedNode.value = question;
       previewOfCut.style.display = "none";

       // call server to get response
//       if (question.split(" ").length){
//           document.getElementById("searchForm").submit();
//       }
  });
});


function testServer(){
  console.log("Calling server for test");
  axios.get("/test").then((response)=>{


  });
}

function getCutsStringMatch(string){
  axios.get("json/cuts/cuts/" + string).then((response)=>{
    responseData = response.data
    return response.data;
  })
  .then(addResponseToPreview);
}

function addResponseToPreview(response){
    // append to preview
    for (var property in response) {
      if (response.hasOwnProperty(property)) {
        let completeString = property + " " + response[property]["description"];
        
        let addToPreview = document.createElement("div");
        addToPreview.innerHTML = completeString;
         previewOfCut.appendChild(addToPreview);
      }
    }

}

function addNewInputToInputGroup(){

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

  COUNT++;
  span.innerHTML = COUNT;

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