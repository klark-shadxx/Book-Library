<template>
  <div id="new-message">

    <img src="../assets/addMessage.png" alt="Forum heading"/>
    
    <form id="input" v-on:submit.prevent="saveMessage()">
      <div>
        <input
          type="text"
          name="title"
          placeholder="Title of message"
          v-model="message.title"
          required
        />
      </div>
      <div>
        <textarea
          name="message"
          placeholder="Message content"
          v-model="message.content"
          required
        />
      </div>
      <div id="button">
        <button class="btn btn-secondary">Post Message</button>
      </div>
    </form>
  </div>
</template>

<script>
// import messageService from "../services/MessageService.js";

export default {
  name: "create-message",
  data() {
    return {
      message: {
        title: "",
        content: "",
      }
    };
  },
  methods: {
    // saveMessage() {
    //   messageService.create(this.message).then((response) => {
    //     if (response.status === 200) {
    //       window.alert("Message Posted!");
    //     }
    //   });
    // },
    saveMessage() {
      let addedMessage = Object.assign(this.message);
      this.$store.commit('SAVE_MESSAGE', addedMessage)
      this.$router.push('/forum-detail')
      window.alert("Successfully added!")

    }
  },
};
</script>

<style scoped>
h1 {
  padding-top: 20px;
  text-align: center;
}

#input {
  padding-left: 22%;
  font-size: 30px;
  margin-top: -20%;
 
}

div {
  padding-bottom: 10px;
}

textarea {
 min-width: 500px;
 min-height: 400px;
 font-size: 30px;
}
#new-message{
  background-image: url(../assets/messageInBottle.jpeg);
  background-repeat: none;
  height: 100vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  background-attachment: fixed;

  display:grid;
  justify-content: right;
}
img{
  padding-top: 10%;
  padding-left: 1%;


}

</style>