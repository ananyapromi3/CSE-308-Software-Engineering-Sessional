import random
import string

def generate_random_passport():
    passport_number = '1' + ''.join(random.choices(string.digits, k=8))
    first_name = ''.join(random.choices(string.ascii_uppercase, k=5))
    return f"{passport_number},{first_name}"

def write_passport_data(file_path, num_entries=50):
    with open(file_path, 'w') as txtfile:
        for _ in range(num_entries):
            passport_data = generate_random_passport()
            txtfile.write(passport_data + '\n')

if __name__ == "__main__":
    file_path = "passport_data.txt"
    write_passport_data(file_path)
    print(f"Passport data written to {file_path}")
