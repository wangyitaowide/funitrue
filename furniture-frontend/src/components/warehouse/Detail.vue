<template>
  <div>
    <el-divider></el-divider>
    <el-row>
      <el-col :span="3" style="text-align: center">
        <span>材料名称</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="name" placeholder="请输入名称"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>原材料编号</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="number" placeholder="请输入编号"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>规格</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="specification" placeholder="请输入规格"></el-input>
      </el-col>
    </el-row>
    <el-row style="margin-top:24px;">
      <el-col :span="3" style="text-align: center">
        <span>单位</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="unit" placeholder="请输入单位"></el-input>
      </el-col>
      <el-col :span="3" style="text-align: center">
        <span>库存数量</span>
      </el-col>
      <el-col :span="4">
        <el-input v-model="useage" placeholder="请输入用量"></el-input>
      </el-col>
    </el-row>
    <el-divider></el-divider>
    <el-row style="text-align: right">
      <el-button type="primary" @click="add">添加</el-button>
      <el-button type="primary">查询</el-button>
    </el-row>
    <el-divider></el-divider>
    <el-table :data="tableData" stripe style="width: 100%">
      <el-table-column prop="name" label="材料名称" min-width="180">
      </el-table-column>
      <el-table-column prop="number" label="原材料编号" min-width="180">
      </el-table-column>
      <el-table-column prop="specification" label="规格" min-width="180">
      </el-table-column>
      <el-table-column prop="unit" label="单位" min-width="180"> </el-table-column>
      <el-table-column prop="useage" label="库存数量" min-width="180"> </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "Wood",
  props: {
    msg: String,
  },
  methods:{
    add(){
      let obj = {
        name:this.name,
        number: this.number,
        specification: this.specification,
        unit: this.unit,
        useage :this.useage
      }
      this.tableData.push(obj);
    }
  },
  data() {
    return {
      name: "",
      number: "",
      specification: "",
      unit: "",
      useage: "",
      tableData: []
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
</style>
