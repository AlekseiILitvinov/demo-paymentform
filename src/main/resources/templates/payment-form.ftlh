<!DOCTYPE html>
<html>
<head>
    <title>Payment Form</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<div class="container">
    <h1>Payment Form</h1>
    <form action="/process-payment" method="post">
        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" step="0.01" required>

        <label for="currency">Currency:</label>
        <input type="text" id="currency" name="currency" required>

        <input type="submit" value="Pay">
    </form>
</div>
</body>
</html>