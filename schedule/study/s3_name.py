import boto3

def s3TableName():
    s3 = boto3.resource('s3')
    for bucket in s3.buckets.all():
        print(bucket.name)

s3TableName()