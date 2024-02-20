function uploadFile() {
    // Implement file upload functionality using JavaScript fetch or XMLHttpRequest
    // This function should handle uploading the Excel file to the backend
    const fileInput = document.getElementById('fileInput');
    const file = fileInput.files[0];
    
    if (file) {
        const formData = new FormData();
        formData.append('file', file);
        
        fetch('/upload', {
            method: 'POST',
            body: formData
        })
        .then(response => {
            if (response.ok) {
                console.log('File uploaded successfully');
                // Optionally, update the UI or trigger data fetching after successful upload
            } else {
                console.error('Failed to upload file');
            }
        })
        .catch(error => {
            console.error('Error uploading file:', error);
        });
    } else {
        console.error('No file selected');
    }
}









function sortData() {
    const sortByField = document.getElementById("sortSelect").value;
    // Implement sorting functionality using JavaScript fetch or XMLHttpRequest
    // This function should send a request to the backend to sort data by the selected field


}

function fetchData() {
    // Implement fetching data from the backend using JavaScript fetch or XMLHttpRequest
    // This function should retrieve data from the backend and populate the table

    
}

// Fetch data when the page loads
window.onload = function() {
    fetchData();
};