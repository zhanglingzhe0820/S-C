Page({
  data: {
    list: [
      {
        restaurant: "致善楼一楼",
        position: 'xx档口',
        name: '咖喱盖饭',
        price: 10.00,
        alreadyOrdered: 49,
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: 100,
        selected: false,
        tempStoredId: "",
        open: false,
      },
      {
        restaurant: "致善楼一楼",
        position: 'xx档口',
        name: '青椒盖饭',
        price: 10.00,
        alreadyOrdered: 49,
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: 100,
        selected: false,
        tempStoredId: "",
        open: false,
      },
      {
        restaurant: "致善楼一楼",
        position: 'xx档口',
        name: '鸡蛋面',
        price: 10.00,
        alreadyOrdered: 49,
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: 100,
        selected: false,
        tempStoredId: "",
        open: false,
      },
      {
        restaurant: "致善楼一楼",
        position: 'xx档口',
        name: '芝士焗生蚝',
        price: 10.00,
        alreadyOrdered: 49,
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: 100,
        selected: false,
        tempStoredId: "",
        open: false,
      },
      {
        restaurant: "致善楼一楼",
        position: 'xxx餐厅',
        name: '大龙虾',
        price: 10.00,
        alreadyOrdered: 49,
        url: "http://imgsrc.baidu.com/imgad/pic/item/a50f4bfbfbedab64c9d958e5fd36afc379311e6f.jpg",
        maxium: 100,
        selected: false,
        tempStoredId: "",
        open: false,
      }
    ],//传输过来的数据
    showList: [],//展现出的数据
    already: "已预订",
    limit: "限额",
    element: "人",
    inputShowed: false,
    inputVal: ""
  },
  onLoad: function (options) {
    //根据request获得食堂id并由此获得菜单
    var restaurantId = options.restaurant;

    //设置食品的餐厅位置
    for (var i = 0; i < this.data.list.length; i++) {
      var restaurantChangeTarget = "list[" + i + "].restaurant";
      this.setData({
        [restaurantChangeTarget]: restaurantId
      })
    }
    
    this.setData({
      showList: this.data.list
    })

    //加载已经选择的商品
    var that = this;
    wx.getStorageInfo({
      success: function (res) {
        var position = [];
        for (var i = 0; i < res.keys.length; i++) {
          if (res.keys[i].indexOf("food") == 0) {
            wx.getStorage({
              key: res.keys[i],
              success: function (subRes) {
                for (var j = 0; j < that.data.list.length; j++) {
                  if (subRes.data.restaurant == that.data.showList[j].restaurant && subRes.data.position == that.data.showList[j].position && subRes.data.name==that.data.showList[j].name) {
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
    console.log(this.data.showList)
  },

  /**
   * 选择
   */
  select: function (e) {
    var that = this;
    wx.getStorageInfo({
      success: function (res) {
        var foodPosition = that.findBtnPosition(e.target.id);
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