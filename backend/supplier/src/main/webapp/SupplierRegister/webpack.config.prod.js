var path = require('path'); //引文文件路径
var webpack = require('webpack');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var HtmlWebpackPlugin = require('html-webpack-plugin');
var CleanWebpackPlugin = require('clean-webpack-plugin');
var Autoprefixer = require('autoprefixer');
var OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
module.exports = {
    devtool: 'source-map',
    entry: ['./src/index'], //入口文件
    output: {
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
                        loader: 'postcss-loader'
                    }
                ]
            },
            {//正则匹配后缀.less文件;
                test: /\.less$/,
                //使用html-webpack-plugin插件独立css到一个文件;
                use: ExtractTextPlugin.extract({
                    use: [{
                        loader: 'css-loader?importLoaders=1',
                    },
                        {
                            loader: 'postcss-loader', //配置参数;
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
        new webpack.optimize.UglifyJsPlugin({
            mangle: {
                except: ['$super', '$', 'exports', 'require']
            }
        }),
        new ExtractTextPlugin("main.css"),
        new HtmlWebpackPlugin({
            template: './src/index.html', //模板路径
            filename: "index.html",
            inject: false,
        }),
        new CleanWebpackPlugin(['dist'], {
            root: __dirname,
            verbose: true,
            dry: false,
        }),
        new OptimizeCssAssetsPlugin({
            assetNameRegExp: /\.css$/g,                //正则匹配后缀.css文件;
            cssProcessor: require('cssnano'),            //加载‘cssnano’css优化插件;
            cssProcessorOptions: {discardComments: {removeAll: true}}, //插件设置,删除所有注释;
            canPrint: true                             //设置是否可以向控制台打日志,默认为true;
        }),
    ],
    devServer: {
        //配置nodejs本地服务器，
        contentBase: './dist',
        hot: true //本地服务器热更新
    },
    resolve: {
        //设置可省略文件后缀名(注:如果有文件没有后缀设置‘’会在编译时会报错,必须改成' '中间加个空格。ps:虽然看起来很强大但有时候省略后缀真不知道加载是啥啊~);
        extensions: [' ', '.css', '.scss', '.sass', '.less', '.js', '.json'],
        //查找module的话从这里开始查找;
        modules: [path.resolve(__dirname, "src"), "node_modules"], //绝对路径;
        //别名设置,主要是为了配和webpack.ProvidePlugin设置全局插件;
        alias: {
            //设置全局jquery插件;
        }
    }
}