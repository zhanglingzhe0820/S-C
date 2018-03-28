var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    openId: "",
    isAuthened: false,
    isStudent: false,
    orderNum: 10,
    dialogIsHiden: true,

    stNumber: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //获得userinfo
    wx.getUserInfo({
      success: function (res) {
        var userInfo = res.userInfo;
        that.setData({
          userInfo: userInfo
        });
      }
    })
    //获得openid
    wx.login({
      success: function (res) {
        var js_code = res.code;
        wx.request({
          url: app.globalData.backendUrl + "getOpenId",
          header: {
            'content-type': 'application/x-www-form-urlencoded'
          },
          data: {
            "jsCode": js_code
          },
          method: 'POST',
          success: function (res) {
            //获得从后端获取认证信息
            if (res.data.length != 0) {
              wx.request({
                url: app.globalData.backendUrl + "confirmState",
                method: "POST",
                header: {
                  'content-type': 'application/x-www-form-urlencoded'
                },
                data: {
                  wechatId: res.data.openid
                },
                success: function (res) {
                  that.setData({
                    isAuthened: res.data.authened,
                    isStudent: res.data.student
                  })
                }
              })
              that.setData({
                openId: res.data.openid
              })
            }
            else {
              wx.showToast({
                title: '系统繁忙',
                icon: 'warn',
                duration: 1000
              });
            }
          }
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

  /**
   * 点击签到（mock）
   */
  onRegisterClicked: function () {
    wx.showToast({
      title: '签到成功',
      icon: 'success',
      duration: 1000
    });
  },

  /**
   * 前往餐盘页面
   */
  toOrder: function () {
    wx.switchTab({
      url: "../cart/cart",
    })
  },

  /**
   * 前往订单界面
   */
  toOrderPreview: function () {
    wx.switchTab({
      url: "../orderPreview/orderPreview",
    })
  },

  closeDialog: function () {
    this.setData({
      dialogIsHiden: true
    })
  },

  /**
   * 认证学号
   */
  confirmDialog: function () {
    //数据库交互认证学号
    wx.request({
      url: app.globalData.backendUrl + "authen",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        wechatId: this.data.openId,
        stNumber: this.data.stNumber
      },
      success: function (res) {
        if (res.data == "Success") {
          wx.showToast({
            title: '认证成功',
            icon: 'success',
            duration: 1000
          });
        } else if (res.data == "DataError") {
          wx.showToast({
            title: '学号已被认证',
            icon: 'warn',
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

    this.setData({
      dialogIsHiden: true
    })

    this.onLoad();
  },

  showDialog: function () {
    this.setData({
      dialogIsHiden: false
    })
  },

  setStNumber: function (e) {
    this.setData({
      stNumber: e.detail.value
    })
  }
})