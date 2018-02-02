// pages/order/order.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    total: 0.00,
    allSelected:true,
    position: [
      {
        name: "xx档口",
        food: [
          {
            foodName: "包子",
            url: "../images/vcode.jpg",
            num: 1,
            canReduce: false,
            price: 5.00,
            selected: true
          },
          {
            foodName: "玉米",
            url: "../images/vcode.jpg",
            num: 2,
            canReduce: true,
            price: 3.00,
            selected: true
          }
        ]
      },
      {
        name: "xx餐厅",
        food: [
          {
            foodName: "包子",
            url: "../images/vcode.jpg",
            num: 1,
            canReduce: false,
            price: 5.00,
            selected: true
          }
        ]
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.calculateAll();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  bindMinus: function (e) {
    var foodPosition = this.findBtnPosition(e.target.id);
    var i = foodPosition[0];
    var j = foodPosition[1];

    var num = this.data.position[i].food[j].num;

    var btnChangeTarget = "position[" + i + "].food[" + j + "].canReduce";
    //达到最小数量无法点击
    if (num <= 2) {
      this.setData(
        {
          [btnChangeTarget]: false
        }
      )
    }

    var numChangeTarget = "position[" + i + "].food[" + j + "].num";
    num--;
    this.setData(
      {
        [numChangeTarget]: num
      }
    )
  },

  bindPlus: function (e) {
    var foodPosition = this.findBtnPosition(e.target.id);
    var i = foodPosition[0];
    var j = foodPosition[1];

    var num = this.data.position[i].food[j].num;

    var btnChangeTarget = "position[" + i + "].food[" + j + "].canReduce";
    //达到最小数量后增加可点击
    if (num >= 1) {
      this.setData(
        {
          [btnChangeTarget]: true
        }
      )
    }

    var changeTarget = "position[" + i + "].food[" + j + "].num";
    num++;
    this.setData(
      {
        [changeTarget]: num
      }
    )
  },

  delete: function (e) {
    var foodPosition = this.findBtnPosition(e.target.id);
    var i = foodPosition[0];
    var j = foodPosition[1];

    //删除元素
    var tempList = [];
    for (var k = 0; k < this.data.position.length; k++) {
      if (k != i) {
        tempList.push(this.data.position[k]);
      }
      else {
        var foodTempList = [];
        for (var p = 0; p < this.data.position[i].food.length; p++) {
          if (p != j) {
            foodTempList.push(this.data.position[i].food[p]);
          }
        }
        if (foodTempList.length != 0) {
          var subTempList = this.data.position[i];
          subTempList.food = foodTempList;
          tempList.push(subTempList);
        }
      }
    }
    this.setData({
      position: tempList
    })
    this.calculateAll();
  },

  select:function(e){
    var foodPosition = this.findBtnPosition(e.target.id);
    var i = foodPosition[0];
    var j = foodPosition[1];

    var selectChangeTarget = "position[" + i + "].food[" + j + "].selected";
    this.setData({
      [selectChangeTarget]:true
    })
    this.calculateAll();
  },

  unselect:function(e){
    var foodPosition = this.findBtnPosition(e.target.id);
    var i = foodPosition[0];
    var j = foodPosition[1];

    var selectChangeTarget = "position[" + i + "].food[" + j + "].selected";
    this.setData({
      [selectChangeTarget]: false
    })
    this.calculateAll();
  },

  selectAll:function(){
    var allList=this.data.position;

    for (var i = 0; i < allList.length;i++){
      for (var j = 0; j < allList[i].food.length;j++){
        allList[i].food[j].selected=true;
      }
    }
    this.setData({
      allSelected:true,
      position:allList
    })
    this.calculateAll();
  },

  unselectAll:function(){
    var allList = this.data.position;

    for (var i = 0; i < allList.length; i++) {
      for (var j = 0; j < allList[i].food.length; j++) {
        allList[i].food[j].selected = false;
      }
    }
    this.setData({
      allSelected: false,
      position: allList
    })
    this.calculateAll();
  },
  
  submit:function(){

  },

  calculateAll:function(){
    var allList = this.data.position;

    var all=0;
    for (var i = 0; i < allList.length; i++) {
      for (var j = 0; j < allList[i].food.length; j++) {
        if(allList[i].food[j].selected == true){
          all += allList[i].food[j].num * allList[i].food[j].price;
        }
      }
    }
    this.setData({
      total:all
    })
  },

  findBtnPosition: function (id) {
    var position = id.split('_')[0];
    var foodName = id.split('_')[1];
    var i = 0;//该食品在position中的位置
    var j = 0;//该食品在food中的位置
    for (; i < this.data.position.length; i++) {
      if (this.data.position[i].name == position) {
        break;
      }
    }
    for (; j < this.data.position[i].food.length; j++) {
      if (this.data.position[i].food[j].foodName == foodName) {
        break;
      }
    }
    return [i, j];
  }
})