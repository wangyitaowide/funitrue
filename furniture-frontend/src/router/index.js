import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/orders",
    name: "Orders",
    component: () =>
      import("../components/orders/Orders.vue")
  },
  {
    path: "/product",
    name: "Product",
    component: () =>
      import("../components/product/Product.vue")
  },
  {
    path: "/warehouse",
    name: "Warehouse",
    component: () =>
      import("../components/warehouse/Warehouse.vue")
  },
  {
    path: "/salary",
    name: "Salary",
    component: () =>
      import("../components/salary/Salary.vue")
  },
  {
    path: "/config",
    name: "Config",
    component: () =>
      import("../components/config/Config.vue")
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
