<template>
    <el-row class="tac">
        <!-- <el-col :span="12"> -->
        <el-col>
            <el-menu
            default-active="2"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose">
                <el-submenu index="1">
                    <template slot="title">
                        <!-- <i class="el-icon-location"></i> -->
                        <span>仓库管理</span>
                    </template>
                    <el-menu-item-group>
                        <!-- <template slot="title">分组一</template> -->
                        <el-menu-item index="1-1">
                            <router-link to="/warehouse">仓储</router-link>
                        </el-menu-item>
                        <el-menu-item index="1-2">选项2</el-menu-item>
                    </el-menu-item-group>
                    <!-- <el-menu-item-group title="分组2">
                        <el-menu-item index="1-3">选项3</el-menu-item>
                    </el-menu-item-group>
                    <el-submenu index="1-4">
                        <template slot="title">选项4</template>
                        <el-menu-item index="1-4-1">选项1</el-menu-item>
                    </el-submenu> -->
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                        <span>产品列表</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="2-1">
                            <router-link to="/product">产品</router-link>
                        </el-menu-item>
                        <el-menu-item index="2-2">选项2</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                        <span>订单管理</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="3-1">
                            <router-link to="/orders">订单</router-link>
                        </el-menu-item>
                        <el-menu-item index="3-2">选项2</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="4">
                    <template slot="title">
                        <span>工资结算</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="4-1">
                            <router-link to="/salary">工资</router-link>
                        </el-menu-item>
                        <el-menu-item index="4-2">选项2</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
                <el-submenu index="5">
                    <template slot="title">
                        <span>系统设置</span>
                    </template>
                    <el-menu-item-group>
                        <el-menu-item index="5-1">
                            <router-link to="/config">配置</router-link>
                        </el-menu-item>
                        <el-menu-item index="5-2">选项2</el-menu-item>
                    </el-menu-item-group>
                </el-submenu>
            </el-menu>
        </el-col>
    </el-row>
</template>

<script>
  export default {
    name:"Aside",
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>