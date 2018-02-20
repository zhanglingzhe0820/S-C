module.exports = {
    devtool: 'eval-source-map',
    entry: __dirname + "/app/main.js",
    output: {
        path: __dirname + "/public/",
        filename: "bundle.js"
    },
    devServer: {
        contentBase: "./public",
        port: "8888",
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
                test: /\.(less)$/,
                loader: ExtractTextPlugin.extract('style?sourceMap', 'css?sourceMap!less?sourceMap!!less?sourceMap'),
                include: /node_modules/
            },
            {
                test: /\.(less)$/,
                loader: ExtractTextPlugin.extract('style?sourceMap', 'css?sourceMap&modules&importLoaders=1&localIdentName=[name]__[local]___[hash:base64:5]!less?sourceMap'),
                exclude: /node_modules/
            },
        ]
    }
}