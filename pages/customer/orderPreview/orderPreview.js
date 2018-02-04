// pages/customer/orderPreview/orderPreview.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    uncompleteOrder:[
      {
        id:2018020300001,
        hour:11,
        minute:20,
        total:100,
        comment:"",
        food:[
          {
            position:"xxx-xxx",
            name:"包子",
            num:5,
            price:10
          },
          {
            position: "xxx-xxx",
            name: "狗粮",
            num: 5,
            price: 10
          }
        ],
      }
    ],
    completeOrder: [
      {
        id: 2018020300001,
        total: 100,
        comment: "",
        food: [
          {
            position: "xxx-xxx",
            name: "包子",
            num: 5,
            price: 10
          },
          {
            position: "xxx-xxx",
            name: "狗粮",
            num: 5,
            price: 10
          }
        ]
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    //从数据库获得所有订单
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

  completeOrder:function(){
    wx.showToast({
      title: '取餐成功',
      icon: 'success',
      duration: 3000
    });
  }
})