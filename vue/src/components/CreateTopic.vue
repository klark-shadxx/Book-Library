<template>
  <form v-on:submit.prevent="saveTopic(); setTopicTitle();">
    <div class="field">
      <div id="input-div">
        <input
          class="form-control form-control-lg"
          type="text"
          placeholder="Add New Topic"
          v-model="forum.forumTopic"
        />
      </div>
      <div id="action">
        <button id="save" class="btn btn-primary btn-lg" type="submit">
          Save Topic
        </button>
      </div>
    </div>
  </form>
</template>

<script>
import forumService from "../services/ForumService";

export default {
  name: "create-topic",
  data() {
    return {
      forum: {
        forumTopic: "",
      },
    };
  },
  methods: {
    saveTopic() {
      forumService.create(this.forum).then((response) => {
        if (response.status === 200) {
          window.alert("Topic Created!");
          this.$router.push("/forum-detail");
        }
      });
    },
    setTopicTitle() {
      this.$store.commit('SET_TOPIC_TITLE', this.forum.forumTopic)
    }
  },
};
</script>

<style>
form {
  padding: 20px;
  font-size: 16px;
}
form * {
  box-sizing: border-box;
  line-height: 1.5;
}
.field {
  display: flex;
  flex-direction: column;
}
.field label {
  margin: 4px 0;
  font-weight: bold;
}
.field input,
.field textarea {
  padding: 8px;
  font-size: 18px;
}
.field textarea {
  height: 300px;
}
.actions {
  text-align: right;
  padding: 10px 0;
}
#addTopic {
  text-align: center;
}
#addTopicBanner {
  max-width: 25%;
}
input {
  max-width: 600px;
  outline: solid 2px #f3969a;
}
#input-div {
  display: flex;
  flex-flow: column wrap;
  align-items: center;
  padding-top: 30px;
  padding-bottom: 30px;
}
#action {
  text-align: center;
}
img {
  padding-top: 100px;
}
</style>
