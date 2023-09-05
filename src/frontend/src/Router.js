import { createRouter, createWebHistory } from 'vue-router';

import Home from './components/Home.vue';
import EmployeeForm from './components/FormEmployee.vue';
import EmployeeList from './components/ListEmployee.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/list', component: EmployeeList },
  { path: '/form', component: EmployeeForm },
  {
      path: '/:pathMatch(.*)*',
      redirect: "/"
  },
];


// const routes = [
//   { path: '/', component: App,
//   children: [
//     { path: '/list', component: EmployeeList },
//     { path: '/form', component: EmployeeForm }
//   ] }
 
// ];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;