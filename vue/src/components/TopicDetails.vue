<template>
    <div id="topic-details">
      <h1>{{ this.$store.state.topicTitle }}</h1>
       <button type="button" class="btn btn-secondary btn-lg">
      <router-link :to="{ name: 'add-message'}">Add New Message</router-link>
      </button>
      <div id="card" class="card bg-light mb-3" style="max-width: 40rem;" v-for="message in this.$store.state.messages" :key="message.id">
        <h3 class="card-title">{{ message.title }}</h3>
        <div class="card-body">
        <h4 class="card-text">{{ message.content }}</h4>
      </div>
    </div>
    </div>
</template>

<script>

export default {
    name: 'topic-details'
}
</script>

<style scoped>

#topic-details {
  text-align: center;
  background-image: url(../assets/quill.jpeg);
  background-attachment: fixed;
  background-repeat: none;
  min-height: 150vh;
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;

 
}

h1 {
    padding-top: 20px;
}

h3 {
    padding-top: 20px;
}
a{
    color: white;
}
#card{
margin: 0 auto;
margin-top: 20px;
}


</style>