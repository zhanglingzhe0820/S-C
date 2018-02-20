var path = require('path'); //引文文件路径
var webpack = require('webpack');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var Autoprefixer = require('autoprefixer');
var OpenBrowserPlugin = require('open-browser-webpack-plugin');
module.exports = {
    devtool: 'cheap-eval-source-map',
    entry: ['./src/index'], //入口文件
    output: {
        publicPath: "http://localhost:8081/",
        path: path.join(__dirname, 'dist'), //打包出口文件路径
        filename: 'index.js' //打包文件名
    },
    module: {
        loaders: [
            {
                test: /\.css$/,
                use: [
                    {
                        loader: 'style-loader',
                    },
                    {
                        loader: 'css-loader',
                        options: {
                            importLoaders: 1,
                        }
                    },
                    {
                        loader: 'postcss-loader',
                        options: {
                            //从postcss插件autoprefixer 添加css3前缀;
                            plugins: function () {
                                return [
                                    //加载autoprefixer并配置前缀,可加载更多postcss插件;
                                    Autoprefixer({
                                        browsers: ['ios >= 7.0']
                                    })
                                ];
                            }
                        }
                    }
                ]
            },
            {
                test: /\.json$/,
                loader: "json-loader"
            },
            {//正则匹配后缀.less文件;
                test: /\.less$/,
                //使用html-webpack-plugin插件独立css到一个文件;
                use:
                    ExtractTextPlugin.extract({
                        use: [{
                            loader: 'css-loader?importLoaders=1',
                        },
                            {
                                loader: 'postcss-loader', //配置参数;
                                options: {
                                    plugins: function () {
                                        return [
                                            Autoprefixer
                                            ({
                                                browsers: ['ios >= 7.0']
                                            })];
                                    }
                                }
                            },
                            //加载less-loader同时也得安装less;
                            "less-loader"
                        ]
                    })
            },
            {
                //正则匹配后缀.js 和.jsx文件;
                test: /\.(js|jsx)$/,
                //需要排除的目录
                exclude: '/node_modules/',
                //加载babel-loader转译es6
                use: [{
                    loader: 'babel-loader',
                }],
            },
        ]
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new ExtractTextPlugin("main.css"),
        new OpenBrowserPlugin({url: 'http://localhost:8081'}),
    ],
    devServer:
        {
            contentBase: './dist',
            hot: true,
            host: '127.0.0.1',
            port: '8081'
        }
}
;