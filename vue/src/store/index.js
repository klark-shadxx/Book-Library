import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    addedBooks: [],
    username: '',
    messages: [
      {
        title: 'I LOVE this book!',
        content: 'Let me just say, this book was such a smooth read! Really, it was like reading butter. I could not believe it! I guess you could say "I could not believe it was not butter!"'
      },
      {
        title: 'Do NOT listen to that person above',
        content: 'This book was anything but smooth. It felt like I was driving on an unpaved road in the Himalayas and let me tell you, I have done that before so I really know what I am talking about. You could say I am an expert!'
      },
  ],
    topicTitle: '',
    messageTitle: "",
    messageContent: ""
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.username = '';
      state.addedBooks = [];
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SAVE_BOOK(state, book) {
      state.addedBooks.push(book);
    },
    SET_USERNAME(state, username) {
      state.username = username;
    },
    SET_MESSAGE_TITLE(state, messageTitle) {
      state.messageTitle = messageTitle;
    },
    SET_MESSAGE_CONTENT(state, messageContent) {
      state.messageContent = messageContent;
    },
    SAVE_MESSAGE(state, message) {
      state.messages.push(message);
    },
    SET_TOPIC_TITLE(state, topicTitle){
      state.topicTitle = topicTitle;
    }

  },
})
//for information that is used across multiple pages