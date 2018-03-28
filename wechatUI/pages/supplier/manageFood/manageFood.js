var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    showList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var supplierUsername = wx.getStorageSync("supplierUsername");
    //加载菜品
    wx.request({
      url: app.globalData.backendSupplierUrl + "getSupplierFoodBySupplierUsername",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        supplierUsername: supplierUsername,
      },
      success: function (res) {
        that.setData({
          showList: res.data
        })
      }
    })
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

  editFood: function (e) {
    var foodPosition = this.findPositionByBtn(e.target.id);
    wx.navigateTo({
      url: "../editFood/editFood?id=" + this.data.showList[foodPosition].id
    });
  },

  deleteFood: function (e) {
    var that = this;
    var foodPosition = this.findPositionByBtn(e.target.id);
    //与后端交互删除本菜品
    wx.request({
      url: app.globalData.backendUrl + "deleteSupplierFood",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        foodId: this.data.showList[foodPosition].id
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.showToast({
            title: '删除成功',
            icon: 'success',
            duration: 1000
          });
        } else {
          wx.showToast({
            title: '系统繁忙',
            icon: 'warn',
            duration: 1000
          });
        }
      }
    })
    //重新加载
    this.onLoad();
  },

  toAddFood: function () {
    wx.navigateTo({
      url: "../addFood/addFood",
    })
  },

  toHome: function () {
    wx.navigateTo({
      url: "../home/home",
    })
  },

  findPositionByBtn: function (id) {
    for (var i = 0; i < this.data.showList.length; i++) {
      if (id == this.data.showList[i].id) {
        return i;
      }
    }
  },
})