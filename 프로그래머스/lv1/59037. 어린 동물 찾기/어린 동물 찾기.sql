-- 코드를 입력하세요
SELECT INS.ANIMAL_ID, INS.NAME
FROM ANIMAL_INS AS INS
WHERE INS.INTAKE_CONDITION NOT LIKE '%Aged%'
ORDER BY INS.ANIMAL_ID