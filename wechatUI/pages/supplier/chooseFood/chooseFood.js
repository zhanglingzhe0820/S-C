// pages/supplier/chooseFood/chooseFood.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    allSelected: true,
    limit: "档口限额",
    element: "人",
    showList: [
      {
        id: 1,
        name: "包子",
        url: "https://thumbs.dreamstime.com/b/pictogram-123-693500.jpg",
        price: 1.0,
        maxium: 100,
        selected: true
      },
      {
        id: 2,
        name: "馒头",
        url: "https://thumbs.dreamstime.com/b/pictogram-123-693500.jpg",
        price: 1.0,
        maxium: 100,
        selected: true
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  unselect: function (e) {
    var foodPosition = this.findPositionByBtn(e.target.id);
    var showList = this.data.showList;
    showList[foodPosition].selected = false;
    this.setData({
      showList: showList
    })
  },

  select: function (e) {
    var foodPosition = this.findPositionByBtn(e.target.id);
    var showList = this.data.showList;
    showList[foodPosition].selected = true;
    this.setData({
      showList: showList
    })
  },

  unselectAll: function () {
    this.setData({
      allSelected: false
    });
    var showList = this.data.showList;
    for (var i = 0; i < showList.length; i++) {
      showList[i].selected = false;
    }
    this.setData({
      showList: showList
    })
  },

  selectAll: function () {
    this.setData({
      allSelected: true
    });
    var showList = this.data.showList;
    for (var i = 0; i < showList.length; i++) {
      showList[i].selected = true;
    }
    this.setData({
      showList: showList
    })
  },

  findPositionByBtn: function (id) {
    for (var i = 0; i < this.data.showList.length; i++) {
      if (id == this.data.showList[i].id) {
        return i;
      }
    }
  },

  completeChoose: function () {
    //与后端交互发布今日菜品
    wx.setStorageSync("isReceivingOrder", true)
    wx.navigateTo({
      url: "../receiveOrder/receiveOrder",
    })
  }
})