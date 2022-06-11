<template>
   
        <body>
             <div class="wrapper">
        <header>Poll Favorite Summer Reads</header>
        <div class="poll-area">
            <label for="">
                <div class="row">
                    <div class="column">
                    <span class="circle"></span>
                    <span class="text">HTML</span>
                    </div>
                    <span class="percent">30%</span>
                </div>
                <div class="progress"></div>
            </label>
             <label for="">
                <div class="row">
                    <div class="column">
                    <span class="circle"></span>
                    <span class="text">jQuery</span>
                    </div>
                    <span class="percent">10%</span>
                </div>
                <div class="progress"></div>
            </label>
             <label for="">
                <div class="row">
                    <div class="column">
                    <span class="circle"></span>
                    <span class="text">Python</span>
                    </div>
                    <span class="percent">20%</span>
                </div>
                <div class="progress"></div>
            </label>
            <label for="">
                <div class="row">
                    <div class="column">
                    <span class="circle"></span>
                    <span class="text">Python</span>
                    </div>
                    <span class="percent">20%</span>
                </div>
                <div class="progress"></div>
            </label>
        </div>
         
    </div>
   </body>
</template>

<style scoped>
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}
body{
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
    background:#6665ee
}
.wrapper{
    background: #fff;
    border-radius: 15px;
    max-width: 380px;
    width: 100%;
    padding: 25px;
}
.wrapper header{
    font-size: 22px;
    font-weight: 600;
}
.wrapper .poll-area{
    margin: 20px 0 15px 0;
}
.poll-area label{
    display: block;
    border-radius: 5px;
    margin-bottom: 10px;
    padding: 8px 15px;
    border: 2px solid #e6e6e6;
}
label .row{
    display: flex;
    justify-content: space-between;
}
label .row .column{
    display: flex;
    align-items: center;
}
label .row .circle{
    height: 19px;
    width: 19px;
    position: relative;
    display: block;
    margin-right: 10px;
    border: 2px solid #ccc;
    border-radius: 50%;
}
.row .circle::after{
    content: "";
    position: absolute;
    height: 11px;
    width: 11px;
    background: red;
    top: 2px;
    left: 2px;
}
</style>