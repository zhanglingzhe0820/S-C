// pages/supplier/receiveOrder/receiveOrder.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orderList: [
      {
        startTime: "11:20",
        endTime: "11:30",
        foodList: [
          {
            name: "包子",
            price: 1.0,
            num: 10
          },
          {
            name: "馒头",
            price: 2.0,
            num: 10
          }
        ]
      },
      {
        startTime: "11:30",
        endTime: "11:40",
        foodList: [
          {
            name: "包子",
            price: 1.0,
            num: 10
          },
          {
            name: "馒头",
            price: 2.0,
            num: 10
          }
        ]
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

  stopReceivingOrder: function () {
    //在后端数据库删除本店食品
    wx.setStorageSync("isReceivingOrder", false)
    wx.navigateTo({
      url: "../home/home",
    })
  }
})