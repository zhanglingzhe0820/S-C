module.exports = {
    devtool: 'source-map',
    entry: __dirname + "/app/index.js",
    output: {
        path: __dirname + "/public/",
        filename: "bundle.js"
    },
    devServer: {
        contentBase: "./public",
        port: "8081",
        inline: true
    },
    module: {
        rules: [
            {
                test: /(\.jsx|\.js)$/,
                use: {
                    loader: "babel-loader",
                },
                exclude: /node_modules/
            },
            {
                test: /\.css$/,
                use: [
                    {
                        loader: "style-loader"
                    }, {
                        loader: "css-loader"
                    }
                ]
            },
            {
                test: /\.(png|jpg|gif)$/i,
                use: [{
                    loader: 'url-loader',
                    options: {
                        limit: 10000,
                        name: '/images/[name].[ext]'
                    }
                },
                {
                    loader: 'img-loader?minimize&optimizationLevel=5&progressive=true'
                },]
            }
        ]
    }
}