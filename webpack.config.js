const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const CleanWebpackPlugin = require('clean-webpack-plugin');

module.exports = {
   entry: path.resolve(__dirname, 'src/main/web/js', 'index.jsx'),
   output: {
      path: path.resolve(__dirname, 'src/main/resources/static/js'),
      filename: 'bundle.js'
   },
   resolve: {
      extensions: ['.js', '.jsx']
   },
   module: {
      rules: [
         {
             test: /\.jsx/,
             use: {
                loader: 'babel-loader',
                options: { presets: ['react', 'es2015'] }
             }
         },
         {
            test: /\.scss/,
            use: ['style-loader', 'css-loader', 'sass-loader']
         }
      ]
   },
   devServer: {
      contentBase: './src/main/web',
      publicPath: '/src/main/resources/static/js'
   },
    plugins: [
        new CleanWebpackPlugin(['src/main/resources/static']),
        new CopyWebpackPlugin([
            { from: './src/main/web/index.html', to:'..' }
        ])
    ]
};