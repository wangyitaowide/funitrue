<template>
  <div>
    <el-divider></el-divider>
    <el-table
      :data="tableData"
      :span-method="objectSpanMethod"
      border
      style="width: 100%; margin-top: 20px">
      <el-table-column
        prop="department"
        label="部门"
        width="180">
      </el-table-column>
      <el-table-column
        prop="number"
        label="材料编号">
      </el-table-column>
      <el-table-column
        prop="specification"
        label="品名规格">
      </el-table-column>
      <el-table-column
        prop="unit"
        label="单位">
      </el-table-column>
      <el-table-column
        prop="useage"
        label="IPCS用量">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: "ProductDetail",
  props: {
    
  },
  components:{
    
  },
  mounted: function(){
    this.rowmerge();
  },
  methods: {
      rowmerge(){
        let pos = [];
        let initpos = 0;
        this.tableData.forEach((element, index) => {
          let result = pos.find(e => e == element.departmentID);
          debugger
          if(!result){
            pos.push(element.departmentID);
            this.rowspanList.push(1);
            initpos = index;
          }else{
            this.rowspanList[initpos] += 1;
            this.rowspanList.push(0);
          };
        });
      },
      objectSpanMethod({rowIndex, columnIndex }) {
        if (columnIndex === 0) {
          if (this.rowspanList[rowIndex] != 0) {
            return {
              rowspan: this.rowspanList[rowIndex],
              colspan: 1
            };
          } else {
            return {
              rowspan: 0,
              colspan: 0
            };
          }
        }
      }
    },
  data() {
    return {
        rowspanList: [],
        tableData: [{
          departmentID: 1,
          department: '钉架部',
          number: 'tt',
          specification: '234',
          unit: '3.2',
          useage: 10
        }, {
          departmentID: 1,
          department: '钉架部',
          number: 'tt',
          specification: '165',
          unit: '4.43',
          useage: 12
        }, {
          departmentID: 2,
          department: '打造底棉',
          number: 'tt',
          specification: '324',
          unit: '1.9',
          useage: 9
        }, {
          departmentID: 3,
          department: '裁皮',
          number: 'tt',
          specification: '621',
          unit: '2.2',
          useage: 17
        }, {
          departmentID: 3,
          department: '裁皮',
          number: 'tt',
          specification: '539',
          unit: '4.1',
          useage: 15
        }]
      }
  }
};
</script>

<style scoped lang="scss">

</style>