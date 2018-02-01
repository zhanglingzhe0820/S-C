// pages/customer/menu/choose.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    restaurant: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData(
      {
        restaurant: [
          {
            name:'致善楼一楼',
            time:'12.00-2.00'
          }, {
            name: '致善楼二楼',
            time: '12.00-2.00'
          },{
            name: '致善楼三楼',
            time: '12.00-2.00'
          }]
      }
    );
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
  
  /**
   * 选择食堂
   */
  choose:function(e){
    var uri="../menu/menu?restaurant="+e.target.id
    console.log(uri)
    wx.navigateTo({
      url: uri
    })
  }
})