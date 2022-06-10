<template>
  <div id="new-message">
    <h1>Add New Message</h1>
    <form id="input" v-on:submit.prevent="saveMessage">
      <div>
        <input
          type="text"
          name="title"
          placeholder="Title of message"
          v-model="message.commentTitle"
          required
        />
      </div>
      <div>
        <textarea
          name="message"
          placeholder="Message content"
          v-model="message.comments"
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
import messageService from "../services/MessageService.js";

export default {
  name: "createMessage",
  data() {
    return {
      message: {
        topic: "",
        commentTitle: "",
        comments: "",
      },
    };
  },
  methods: {
    saveMessage() {
      messageService.create(this.message).then((response) => {
        if (response.status === 200) {
          window.alert("Message Posted!");
        }
      });
    },
  },
};
</script>

<style scoped>
h1 {
  padding-top: 20px;
  text-align: center;
}

#input {
  padding-left: 460px;
}

div {
  padding-bottom: 10px;
}

textarea {
  width: 370px;
  height: 180px;
}
</style>