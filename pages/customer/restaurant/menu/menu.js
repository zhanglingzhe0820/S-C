var app = getApp();
Page({
  data: {
    list: [],//传输过来的数据
    showList: [],//展现出的数据
    already: "已预订",
    limit: "限额",
    element: "人",
    inputShowed: false,
    inputVal: ""
  },
  onLoad: function (options) {
    var that = this;
    var restaurantId = options.restaurant;
    //根据request获得食堂id并由此获得菜单
    wx.request({
      url: app.globalData.backendUrl + "getFoodListByRestaurant",
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      data: {
        restaurantId: restaurantId
      },
      success: function (res) {
        var tempList = [];
        for (var i = 0; i < res.data.length; i++) {
          var tempFood = {};
          tempFood.id = res.data[i].id;
          tempFood.restaurant = res.data[i].restaurantReturnVo.name;
          tempFood.position = res.data[i].position;
          tempFood.name = res.data[i].name;
          tempFood.price = res.data[i].price;
          tempFood.alreadyOrdered = res.data[i].currentOrders;
          tempFood.url = res.data[i].url;
          tempFood.maxium = res.data[i].maximum;
          tempFood.hasChoice = res.data[i].hasChoice;
          tempFood.choice = res.data[i].choice;
          tempFood.specialChoice = "";
          tempFood.selected = false;
          tempFood.tempStoredId = "";
          tempList.push(tempFood);
        }
        that.setData({
          list: tempList
        })

        that.setData({
          showList: that.data.list
        })

        //加载已经选择的商品
        wx.getStorageInfo({
          success: function (res) {
            var position = [];
            for (var i = 0; i < res.keys.length; i++) {
              if (res.keys[i].indexOf("food") == 0) {
                wx.getStorage({
                  key: res.keys[i],
                  success: function (subRes) {
                    for (var j = 0; j < that.data.list.length; j++) {
                      if (subRes.data.restaurant == that.data.showList[j].restaurant && subRes.data.position == that.data.showList[j].position && subRes.data.name == that.data.showList[j].name) {
                        var selectChangeTarget = "showList[" + j + "].selected";
                        var tempIdChangeTarget = "showList[" + j + "].tempStoredId";
                        that.setData({
                          [selectChangeTarget]: true,
                          [tempIdChangeTarget]: subRes.data.tempStoredId
                        })
                      }
                    }
                  },
                })
              }
            }
          },
        })
      }
    })
  },

  showInput: function () {
    this.setData({
      inputShowed: true
    });
  },
  hideInput: function () {
    this.setData({
      inputVal: "",
      inputShowed: false
    });
  },
  clearInput: function () {
    this.setData({
      inputVal: ""
    });
  },

  search: function (e) {
    this.setData({
      inputVal: e.detail.value
    });
    var tempList = [];
    for (var i = 0; i < this.data.list.length; i++) {
      if (this.data.list[i].name.indexOf(this.data.inputVal) != -1) {
        tempList.push(this.data.list[i]);
      }
    }
    this.setData({
      showList: tempList
    })
  },

  /**
   * 选择
   */
  select: function (e) {
    var foodPosition = this.findBtnPosition(e.target.id);
    var that = this;
    //如果有特殊口味选择
    if(showList.data[foodPosition].hasChoice){
      //显示选项窗口
    }
    wx.getStorageInfo({
      success: function (res) {
        var nextId;
        var maxId = 0;
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("food") == 0) {
            var id = parseInt(res.keys[i].substring(4), 10);
            if (id > maxId) {
              maxId = id;
            }
          }
        }
        nextId = maxId + 1;

        var selectChangeTarget = "showList[" + foodPosition + "].selected";
        that.setData({
          [selectChangeTarget]: true
        });
        var tempDataChangeTarget = "showList[" + foodPosition + "].tempStoredId";
        that.setData({
          [tempDataChangeTarget]: "food" + nextId
        });

        //添加至餐盘
        var selectedFood = that.data.showList[foodPosition];
        selectedFood.name = selectedFood.name + selectedFood.specialChoice.length == 0 ? "" : "("
          + selectedFood.specialChoice + ")";
        wx.setStorageSync(
          "food" + nextId,
          that.data.showList[foodPosition],
        );
      },
    })
  },

  /**
   * 取消选择（mock）
   */
  unselect: function (e) {
    //从餐盘删除
    var that = this;
    var foodPosition = that.findBtnPosition(e.target.id);
    var tempFoodId = this.data.showList[foodPosition].tempStoredId;
    wx.removeStorage({
      key: tempFoodId,
      success: function (res) {
        var selectChangeTarget = "showList[" + foodPosition + "].selected";
        that.setData({
          [selectChangeTarget]: false
        })
      },
    })
  },

  completeChoose: function (e) {
    wx.switchTab({
      url: "../../cart/cart",
    })
  },

  findBtnPosition: function (id) {
    var position = id.split("_")[0];
    var name = id.split("_")[1];
    for (var i = 0; i < this.data.list.length; i++) {
      if (this.data.list[i].position == position && this.data.list[i].name == name) {
        return i;
      }
    }
  }
});