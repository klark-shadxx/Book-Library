<template >
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <header class="one">
      <img id = "LogIn" src="../assets/LogIn.png"/>
      </header>
      <div class ="two">
      <img id = "swim" src="../assets/CityBooks.jpeg"/>
      </div>
      <h1 class="h1 mb-3 font-weight-normal" id="sign-in">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      
      <label for="username" class="sr-only">Username</label>
      <div class="input">
        <input
          type="text"
          id="username"
          class="form-control"
          placeholder="Username"
          v-model="user.username"
          required
          autofocus
        />
     <div></div>
      <label for="password" class="sr-only">Password</label>
       <input
         type="password"
         id="password"
         class="form-control"
         placeholder="Password"
         v-model="user.password"
         required
       />
      </div>
      <div>
      <button class="btn btn-lg btn-primary btn-block" @click="playSound()" type="submit" id = "submit">Sign in</button>
     </div>
    <router-link :to="{ name: 'register' }">Need an account?</router-link>
  </form>
  </div>
</template>

<script>
var audio = new Audio("../assets/windchime.mp3");
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    
    return {
      user: {
        username: "",
        password: "",
      },
   
      invalidCredentials: false,
      
  
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$store.commit("SET_USERNAME", response.data.user.username);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
   
      playSound() {
      audio.play();
}
    }
 
    };
</script>

<style scoped>
/* #login{
display: grid;
grid-template-columns: 1fr, 1fr, 1fr;
gap: 10px;
grid-template-areas: 
"header    header   header   header"
 "picture  sign-in  sign-in  sign-in"  
 "picture  input    input   input" */


 img{
    max-width: 50%;
    height:auto;
    grid-area: picture;
    padding-top:10px;
  }
#welcome-banner{
  font-size: 4em;
  padding: 15px;
}
.two{
  grid-area: picture;
}
.sign-in{
  grid-area: sign-in;
}

label {
  font-size: 2rem;
  padding-top: 20px;
}

.input {
  display: flex;
  flex-flow: column wrap;
  align-items: center;
  padding-top: px;
  padding-bottom: 30px;
}

#checkbox-text {
  font-size: 20px;
  font-weight: bolder;
}
#LogIn{
  text-align: center;
  padding-top: 30px;
  max-width: 1000px;
}


</style>