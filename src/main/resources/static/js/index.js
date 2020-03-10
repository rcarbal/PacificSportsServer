let COUNT = 1;
let tempNode = undefined;
let tempParent = undefined;
let userQuery = undefined;
let responseData = undefined;
let preview = undefined;

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

     
      tempNode = data.srcElement;
      tempParent = data.srcElement.parentNode;
      userQuery = tempNode.value;
      preview = tempParent.childNodes[3];


      if (preview.hasChildNodes()){
          preview.innerHTML = "";
      }

      preview.style.display = "block";
      
      let array = userQuery.split(" ");

      var isNum = /^\d+$/.test(array[0]);

      if(isNum){
        getCutsStringMatch(array[0]);
      }
       
    }
  });
}

// Get preview selection
// get child from preview div
$(document).ready(function() {
  $('.search-bar-results').on('click', function(event) {
      // event.stopPropagation();
      const question = event.target.innerHTML;
      console.log(question);

       // get search and set search bar
       const search = document.getElementById('searchInput');
       tempNode.value = question;

       console.log(preview);
       preview.style.display = "none";

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
         preview.appendChild(addToPreview);
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