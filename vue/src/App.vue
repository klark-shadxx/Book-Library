<template>
  <div id="app">
    <div id="nav" class="navbar navbar-expand-lg navbar-dark bg-primary">
      <router-link class="navbar-brand" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>&nbsp;&nbsp;
      <router-link class="navbar-brand" v-bind:to="{name: 'ReadingList'}"  v-if="$store.state.token != ''">My Reading List</router-link>&nbsp;&nbsp;
      <router-link class="navbar-brand" v-bind:to="{name: 'ForumView'}" v-if="$store.state.token != ''">Forum</router-link>
      <router-link class="navbar-brand" v-bind:to="{ name: 'AddBook' }" v-if="$store.state.username == 'admin'">Add a New Book</router-link>
      <router-link class="navbar-brand" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    
    </div>
    <router-view />
  </div>
</template>

<script>

</script>


<style>

#nav {
padding-left: 30px;
font-size:large;


}




</style>